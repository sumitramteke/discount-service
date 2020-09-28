package eg.sumitramteke.discount.service;

import java.util.List;

import eg.sumitramteke.discount.exception.ServiceException;
import eg.sumitramteke.discount.model.Discount;
import eg.sumitramteke.discount.vo.DiscountReqPayload;
import eg.sumitramteke.discount.vo.DiscountVO;

public interface DiscountService {
  DiscountVO save(Discount discount) throws ServiceException;

  List<DiscountVO> saveAll(List<Discount> discounts) throws ServiceException;

  DiscountVO findById(final String id) throws ServiceException;

  List<DiscountVO> findAll() throws ServiceException;

  DiscountVO update(Discount discount) throws ServiceException;

  DiscountVO remove(final String id) throws ServiceException;

  List<DiscountVO> findByEmail(final String email) throws ServiceException;

  DiscountVO applyDiscount(final DiscountReqPayload payload) throws ServiceException;
}
