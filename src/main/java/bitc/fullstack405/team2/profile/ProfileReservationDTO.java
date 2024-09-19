package bitc.fullstack405.team2.profile;

import lombok.Data;

@Data
public class ProfileReservationDTO {
    private int resId;
    private int resTime;
    private String reservationDate;
    private String state;
    private String createdAt;
    private String cafeId;
    private String themeId;
    private String cafeName;
    private String themeTitle;
}
