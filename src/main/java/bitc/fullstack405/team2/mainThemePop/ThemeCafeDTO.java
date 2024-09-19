package bitc.fullstack405.team2.mainThemePop;

import lombok.Data;

@Data
public class ThemeCafeDTO {
    private int themeIdx;
    private String title;
    private String themeRank;
    private String genre;
    private String synopsis;
    private int people;
    private int playTime;
    private int payment;
    private String imgUrl;

    private int cafeId;
    private String name;
    private String address;
    private String phone;
    private String cafeImg;
    private String salesTimes;

    private int boardIdx;
    private String commTitle;
    private String commThemeIdx;

    private int peopleLimit;

}
