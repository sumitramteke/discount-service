package eg.sumitramteke.discount.vo;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import eg.sumitramteke.discount.model.Discount;
import eg.sumitramteke.discount.model.Offer;
import eg.sumitramteke.discount.model.Recipient;

public class DiscountVO {
  private String id;

  private String code;

  private boolean applied;

  private Date appliedDt;

  private Date expiryDt;

  private Recipient recipient;

  private Offer offer;

  public DiscountVO() {
  }

  public DiscountVO(Discount discount) {
    BeanUtils.copyProperties(discount, this);
  }

  public DiscountVO(Discount discount, Offer offer, Recipient recipient) {
    BeanUtils.copyProperties(discount, this);
    this.offer = offer;
    this.recipient = recipient;
  }

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

  public Recipient getRecipient() {
    return recipient;
  }

  public void setRecipient(Recipient recipient) {
    this.recipient = recipient;
  }

  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }
}
