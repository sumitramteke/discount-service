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

import eg.sumitramteke.discount.model.Recipient;
import eg.sumitramteke.discount.service.RecipientService;

@RestController
@RequestMapping("/recipients")
public class RecipientController {

  @Autowired
  private RecipientService recipientService;

  @GetMapping
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(this.recipientService.findAll());
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Recipient recipient) {
    return ResponseEntity.ok(this.recipientService.save(recipient));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable String id, @RequestBody Recipient recipient) {
    return ResponseEntity.ok(this.recipientService.update(recipient));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> remove(@PathVariable String id) {
    return ResponseEntity.ok(this.recipientService.remove(id));
  }

}