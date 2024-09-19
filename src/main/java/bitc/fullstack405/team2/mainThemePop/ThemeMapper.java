package bitc.fullstack405.team2.mainThemePop;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.context.Theme;

import java.util.List;

@Mapper
public interface ThemeMapper {
  List <ThemeDTO> selectThemeList() throws Exception;

  List <ThemeCafeDTO> selectThemeCafeList() throws Exception;

  ThemeDTO selectCafe() throws Exception;

  List<ThemeCafeDTO> mainItemsList(int idx) throws Exception;

  ThemeCafeDTO selectTheme(@Param("cafeId") int cafeId,  @Param("themeId") int themeId) throws Exception;

  List<ThemeCafeDTO> selectReviewList() throws Exception;

  List<ThemeCafeDTO> selectAjaxReviewList(@Param("cafeIdx") int cafeIdx, @Param("themeIdx") int themeIdx) throws Exception;

  // [추가] 특정 카페 이름에 대한 테마 목록을 조회하는 메서드
  List<ThemeDTO> getThemesForCafe(String cafeName);
}
