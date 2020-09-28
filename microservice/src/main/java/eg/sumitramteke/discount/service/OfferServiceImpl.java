package eg.sumitramteke.discount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eg.sumitramteke.discount.exception.ServiceException;
import eg.sumitramteke.discount.model.Offer;
import eg.sumitramteke.discount.repository.OfferRepository;

@Service("offerService")
public class OfferServiceImpl implements OfferService {

  @Autowired
  private OfferRepository offerRepo;

  @Override
  public Offer save(Offer offer) throws ServiceException {
    return this.offerRepo.save(offer);
  }

  @Override
  public List<Offer> findAll() throws ServiceException {
    return this.offerRepo.findAll();
  }

  @Override
  public Offer findById(String id) throws ServiceException {
    final Optional<Offer> offer = this.offerRepo.findById(id);
    if (offer.isEmpty()) {
      throw new ServiceException("Offer not found");
    }
    return offer.get();
  }

  @Override
  public Offer update(Offer offer) throws ServiceException {
    if (this.offerRepo.findById(offer.getId()).isEmpty()) {
      throw new ServiceException("Offer not found");
    }
    return this.offerRepo.save(offer);
  }

  @Override
  public Offer remove(String id) throws ServiceException {
    final Optional<Offer> offer = this.offerRepo.findById(id);
    if (offer.isEmpty()) {
      throw new ServiceException("Offer not found");
    }
    this.offerRepo.delete(offer.get());
    return offer.get();
  }

}
