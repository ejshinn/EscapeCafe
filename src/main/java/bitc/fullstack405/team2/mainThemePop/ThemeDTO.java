package bitc.fullstack405.team2.mainThemePop;

import lombok.Data;

@Data
public class ThemeDTO {
  private int themeId;
  private String title;
  private String themeRank;
  private String genre;
  private String synopsis;
  private int people;
  private int playTime;
  private int payment;
  private String imgUrl;
  private int themeIdx; // 추가
}
