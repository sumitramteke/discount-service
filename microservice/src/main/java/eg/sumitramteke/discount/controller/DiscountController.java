package eg.sumitramteke.discount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eg.sumitramteke.discount.model.Discount;
import eg.sumitramteke.discount.service.DiscountService;
import eg.sumitramteke.discount.vo.DiscountReqPayload;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

  @Autowired
  private DiscountService discountService;

  @GetMapping
  public ResponseEntity<?> findAll(@RequestParam(required = false) String email) {
    if (email != null) {
      return ResponseEntity.ok(this.discountService.findByEmail(email));
    }
    return ResponseEntity.ok(this.discountService.findAll());
  }

  @PostMapping
  public ResponseEntity<?> saveAll(@RequestBody List<Discount> discounts) {
    return ResponseEntity.ok(this.discountService.saveAll(discounts));
  }

  @PutMapping
  public ResponseEntity<?> applyDiscount(@RequestBody DiscountReqPayload payload) {
    return ResponseEntity.ok(this.discountService.applyDiscount(payload));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> remove(@PathVariable String id) {
    return ResponseEntity.ok(this.discountService.remove(id));
  }

}