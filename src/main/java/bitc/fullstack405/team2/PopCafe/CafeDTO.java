package bitc.fullstack405.team2.PopCafe;

import lombok.Data;

@Data
public class CafeDTO {
  private int cafeId;
  private String name;
  private String address;
  private String phone;
  private String cafeImg;
  private String salesTimes;
  private String reservationOpenTimes;
}
