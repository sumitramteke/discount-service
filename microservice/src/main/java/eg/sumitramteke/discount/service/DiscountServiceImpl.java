package eg.sumitramteke.discount.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eg.sumitramteke.discount.exception.ServiceException;
import eg.sumitramteke.discount.model.Discount;
import eg.sumitramteke.discount.model.Offer;
import eg.sumitramteke.discount.model.Recipient;
import eg.sumitramteke.discount.repository.DiscountRepository;
import eg.sumitramteke.discount.repository.OfferRepository;
import eg.sumitramteke.discount.repository.RecipientRepository;
import eg.sumitramteke.discount.vo.DiscountReqPayload;
import eg.sumitramteke.discount.vo.DiscountVO;

@Service("discountService")
public class DiscountServiceImpl implements DiscountService {

  @Autowired
  private DiscountRepository discountRepo;

  @Autowired
  private OfferRepository offerRepo;

  @Autowired
  private RecipientRepository recipientRepo;

  @Override
  public DiscountVO save(Discount discount) throws ServiceException {
    final Optional<Offer> offer = this.offerRepo.findById(discount.getOfferId());
    final Optional<Recipient> recipient = this.recipientRepo.findById(discount.getRecipientId());
    if (offer.isEmpty() || recipient.isEmpty()) {
      throw new ServiceException("Bad Request");
    }
    discount = this.discountRepo.save(discount);

    if (discount == null) {
      throw new ServiceException("Fail to apply changes");
    }
    return new DiscountVO(discount, offer.get(), recipient.get());
  }

  @Override
  public List<DiscountVO> saveAll(List<Discount> discounts) throws ServiceException {
    try {
      final Map<String, List<Discount>> discountByOffer = discounts.stream()
          .collect(Collectors.groupingBy(Discount::getOfferId));
      final List<DiscountVO> discountVOs = new ArrayList<>();

      discountByOffer.entrySet().stream().forEach(e -> {
        final Optional<Offer> offer = this.offerRepo.findById(e.getKey());
        if (offer.isEmpty()) {
          return;
        }
        e.getValue().stream().forEach(d -> {
          final Optional<Recipient> recipient = this.recipientRepo.findById(d.getRecipientId());
          if (recipient.isEmpty()) {
            return;
          }
          d.setCode(UUID.randomUUID().toString());
          final DiscountVO dvo = new DiscountVO(this.discountRepo.save(d), offer.get(), recipient.get());
          discountVOs.add(dvo);
        });
      });
      return discountVOs;
    } catch (Exception ex) {
      throw new ServiceException("Fail to perform bulk operation");
    }
  }

  @Override
  public List<DiscountVO> findAll() throws ServiceException {
    final List<Discount> discounts = this.discountRepo.findAll();
    final List<DiscountVO> discountVOs = new ArrayList<>();
    final Map<String, List<Discount>> discountByOffer = discounts.stream()
        .collect(Collectors.groupingBy(Discount::getOfferId));
    discountByOffer.entrySet().stream().forEach(e -> {
      final Optional<Offer> offer = this.offerRepo.findById(e.getKey());
      if (offer.isEmpty()) {
        return;
      }
      e.getValue().stream().forEach(d -> {
        final Optional<Recipient> recipient = this.recipientRepo.findById(d.getRecipientId());
        if (recipient.isEmpty()) {
          return;
        }
        discountVOs.add(new DiscountVO(d, offer.get(), recipient.get()));
      });
    });
    return discountVOs;
  }

  @Override
  public DiscountVO findById(final String id) throws ServiceException {
    final Optional<Discount> discountOp = this.discountRepo.findById(id);
    if (discountOp.isEmpty()) {
      throw new ServiceException("Discount not found");
    }
    final Discount discount = discountOp.get();
    final Optional<Offer> offer = this.offerRepo.findById(discount.getOfferId());
    final Optional<Recipient> recipient = this.recipientRepo.findById(discount.getRecipientId());
    if (offer.isEmpty() || recipient.isEmpty()) {
      throw new ServiceException("Internal Server Error");
    }
    return new DiscountVO(discount, offer.get(), recipient.get());
  }

  @Override
  public DiscountVO update(Discount discount) throws ServiceException {
    Optional<Discount> dOptional = this.discountRepo.findById(discount.getId());
    if (dOptional.isEmpty()) {
      throw new ServiceException("Discount not found");
    }
    final Optional<Offer> offer = this.offerRepo.findById(discount.getOfferId());
    final Optional<Recipient> recipient = this.recipientRepo.findById(discount.getRecipientId());
    if (offer.isEmpty() || recipient.isEmpty()) {
      throw new ServiceException("Bad Request");
    }

    final Discount orgDiscount = dOptional.get();
    if (discount.isApplied() && !orgDiscount.isApplied()) {
      orgDiscount.setApplied(true);
      orgDiscount.setAppliedDt(new Date());
    }

    discount = this.discountRepo.save(orgDiscount);
    return new DiscountVO(discount, offer.get(), recipient.get());
  }

  @Override
  public DiscountVO remove(final String id) throws ServiceException {
    final Discount discount = this.discountRepo.findById(id)
    .orElseThrow(() -> new ServiceException("Discount not found"));
    final Optional<Offer> offer = this.offerRepo.findById(discount.getOfferId());
    final Optional<Recipient> recipient = this.recipientRepo.findById(discount.getRecipientId());
    if (offer.isEmpty() || recipient.isEmpty()) {
      throw new ServiceException("Bad Request");
    }
    this.discountRepo.delete(discount);
    return new DiscountVO(discount, offer.get(), recipient.get());
  }

  @Override
  public List<DiscountVO> findByEmail(final String email) throws ServiceException {
    final Optional<Recipient> recipient = this.recipientRepo.findByEmail(email);
    if (recipient.isEmpty()) {
      throw new ServiceException("Recipient not found");
    }
    final List<Discount> discounts = this.discountRepo.findByRecipientId(recipient.get().getId());
    final List<DiscountVO> discountVOs = new ArrayList<>();
    final Map<String, List<Discount>> discountByOffer = discounts.stream()
        .collect(Collectors.groupingBy(Discount::getOfferId));
    discountByOffer.entrySet().stream().forEach(e -> {
      final Optional<Offer> offer = this.offerRepo.findById(e.getKey());
      if (offer.isEmpty()) {
        return;
      }
      e.getValue().stream().forEach(d -> {
        discountVOs.add(new DiscountVO(d, offer.get(), recipient.get()));
      });
    });
    return discountVOs;
  }

  @Override
  public DiscountVO applyDiscount(final DiscountReqPayload payload) throws ServiceException {
    final Optional<Recipient> recipient = this.recipientRepo.findByEmail(payload.getEmail());
    if (recipient.isEmpty()) {
      throw new ServiceException("Recipient not found");
    }
    final String code = payload.getCode();
    final Optional<Discount> discountOp = this.discountRepo.findByRecipientIdAndCode(recipient.get().getId(), code);

    if (discountOp.isEmpty()) {
      throw new ServiceException("Discount not found");
    }
    Discount discount = discountOp.get();
    final Optional<Offer> offer = this.offerRepo.findById(discount.getOfferId());

    if (discount.isApplied()) {
      throw new ServiceException("Recipient already applied code '" + code + "'");
    }

    final Date appliedDt = new Date();
    if (!appliedDt.before(discount.getExpiryDt())) {
      throw new ServiceException("Discount code '" + code + "' expired already");
    }

    discount.setApplied(true);
    discount.setAppliedDt(appliedDt);

    discount = this.discountRepo.save(discount);
    if (discount == null) {
      throw new ServiceException("Not able to apply discount");
    }
    return new DiscountVO(discount, offer.get(), recipient.get());
  }

}
