package eg.sumitramteke.discount.vo;

import java.util.Date;

public class DiscountReqPayload {

  private String email;

  private String code;

  private Date createdDt;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Date getCreatedDt() {
    return createdDt;
  }

  public void setCreatedDt(Date createdDt) {
    this.createdDt = createdDt;
  }

}
