package eg.sumitramteke.discount.service;

import java.util.List;

import eg.sumitramteke.discount.exception.ServiceException;
import eg.sumitramteke.discount.model.Offer;

public interface OfferService {
  Offer save(Offer offer) throws ServiceException;

  Offer findById(String id) throws ServiceException;

  List<Offer> findAll() throws ServiceException;

  Offer update(Offer offer) throws ServiceException;

  Offer remove(String id) throws ServiceException;
}
