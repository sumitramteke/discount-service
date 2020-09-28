package eg.sumitramteke.discount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eg.sumitramteke.discount.exception.ServiceException;
import eg.sumitramteke.discount.model.Recipient;
import eg.sumitramteke.discount.repository.RecipientRepository;

@Service("recipientService")
public class RecipientServiceImpl implements RecipientService {

  @Autowired
  private RecipientRepository recipientRepo;

  @Override
  public Recipient save(Recipient recipient) throws ServiceException {
    if (this.recipientRepo.findByEmail(recipient.getEmail()).isPresent()) {
      throw new ServiceException("Recipient already exist");
    }
    return this.recipientRepo.save(recipient);
  }

  @Override
  public List<Recipient> findAll() throws ServiceException {
    return this.recipientRepo.findAll();
  }

  @Override
  public Recipient findOneByEmail(String email) throws ServiceException {
    final Optional<Recipient> recipient = this.recipientRepo.findById(email);
    if (recipient.isEmpty()) {
      throw new ServiceException("Recipient not found");
    }
    return recipient.get();
  }

  @Override
  public Recipient update(Recipient recipient) throws ServiceException {
    if (this.recipientRepo.findByEmail(recipient.getEmail()).isEmpty()) {
      throw new ServiceException("Recipient not found");
    }
    return this.recipientRepo.save(recipient);
  }

  @Override
  public Recipient remove(String id) throws ServiceException {
    final Optional<Recipient> recipient = this.recipientRepo.findById(id);
    if (recipient.isEmpty()) {
      throw new ServiceException("Recipient not found");
    }
    this.recipientRepo.delete(recipient.get());
    return recipient.get();
  }

}
