
package eg.sumitramteke.discount.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "discount")
public class Discount {

  @Id
  private String id;

  private String code;

  private String recipientId;

  private String offerId;

  private boolean applied;

  private Date appliedDt;

  private Date expiryDt;

  @CreatedDate
  private Date createdDt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(String recipientId) {
    this.recipientId = recipientId;
  }

  public String getOfferId() {
    return offerId;
  }

  public void setOfferId(String offerId) {
    this.offerId = offerId;
  }

  public boolean isApplied() {
    return applied;
  }

  public void setApplied(boolean applied) {
    this.applied = applied;
  }

  public Date getAppliedDt() {
    return appliedDt;
  }

  public void setAppliedDt(Date appliedDt) {
    this.appliedDt = appliedDt;
  }

  public Date getExpiryDt() {
    return expiryDt;
  }

  public void setExpiryDt(Date expiryDt) {
    this.expiryDt = expiryDt;
  }

  public Date getCreatedDt() {
    return createdDt;
  }

  public void setCreatedDt(Date createdDt) {
    this.createdDt = createdDt;
  }

}
