package bitc.fullstack405.team2.cafeResrvation;

import lombok.Data;

@Data
public class ResDTO {
  private int resId;
  private int resTime;
  private String reservationDate;
  private String state;
  private int cafeId;
  private String userId;
  private int themeId;
  private String cafeName;
  private String themeTitle;

  private int resPayment;
  private int resPeople;
  private String serialNum;
}
