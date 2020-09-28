package eg.sumitramteke.discount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eg.sumitramteke.discount.model.Offer;
import eg.sumitramteke.discount.service.OfferService;

@RestController
@RequestMapping("/offers")
public class OfferController {

  @Autowired
  private OfferService offerService;

  @GetMapping
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(this.offerService.findAll());
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Offer offer) {
    return ResponseEntity.ok(this.offerService.save(offer));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable String id, @RequestBody Offer offer) {
    return ResponseEntity.ok(this.offerService.save(offer));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> remove(@PathVariable String id) {
    return ResponseEntity.ok(this.offerService.remove(id));
  }

}