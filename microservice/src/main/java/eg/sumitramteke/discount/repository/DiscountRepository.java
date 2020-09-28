package eg.sumitramteke.discount.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eg.sumitramteke.discount.model.Discount;

@Repository("discountRepo")
public interface DiscountRepository extends MongoRepository<Discount, String> {
  Optional<Discount> findByCode(String code);

  List<Discount> findByRecipientId(String recipientId);

  Optional<Discount> findByRecipientIdAndCode(String recipientId, String code);
}