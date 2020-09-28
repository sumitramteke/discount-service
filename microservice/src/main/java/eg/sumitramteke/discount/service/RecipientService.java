package eg.sumitramteke.discount.service;

import java.util.List;

import eg.sumitramteke.discount.exception.ServiceException;
import eg.sumitramteke.discount.model.Recipient;

public interface RecipientService {
  Recipient save(Recipient recipient) throws ServiceException;

  List<Recipient> findAll() throws ServiceException;

  Recipient findOneByEmail(String email) throws ServiceException;

  Recipient update(Recipient recipient) throws ServiceException;

  Recipient remove(String id) throws ServiceException;
}
