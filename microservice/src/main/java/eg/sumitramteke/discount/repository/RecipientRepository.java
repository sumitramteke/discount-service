package eg.sumitramteke.discount.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eg.sumitramteke.discount.model.Recipient;

@Repository("recipientRepo")
public interface RecipientRepository extends MongoRepository<Recipient, String> {

  Optional<Recipient> findByEmail(String email);

}
