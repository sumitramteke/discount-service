package eg.sumitramteke.discount.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eg.sumitramteke.discount.model.Offer;

@Repository("offerRepo")
public interface OfferRepository extends MongoRepository<Offer, String> {
}