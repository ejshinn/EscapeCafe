package bitc.fullstack405.team2.mainThemePop;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.context.Theme;

import java.util.List;
@Service
public class ThemeServiceImpl implements
    ThemeService {
  @Autowired
  private ThemeMapper themeMapper;

  @Override
  public ThemeCafeDTO selectTheme(int cafeId,int themeId) throws Exception {
    return themeMapper.selectTheme(cafeId, themeId);
  }

  @Override
  public List<ThemeDTO> selectThemeList() throws Exception {
    return themeMapper.selectThemeList();
  }
 @Override
  public List<ThemeCafeDTO> selectThemeCafeList() throws Exception {
    return themeMapper.selectThemeCafeList();
  }

  @Override
  public ThemeDTO selectCafe() throws Exception {
    return themeMapper.selectCafe();
  }

  @Override
  public List<ThemeCafeDTO> mainItemsList(int idx) throws Exception {
    return themeMapper.mainItemsList(idx);
  }

  @Override
  public List<ThemeCafeDTO> selectReviewList() throws Exception {
    return themeMapper.selectReviewList();
  }

  @Override
  public List<ThemeCafeDTO> selectAjaxReviewList(int cafeIdx, int themeIdx) throws Exception {
    return themeMapper.selectAjaxReviewList(cafeIdx, themeIdx);
  }

  // [추가] 특정 카페 이름에 대한 테마 목록을 조회하는 메서드
  public List<ThemeDTO> getThemesForCafe(String cafeName) {
    return themeMapper.getThemesForCafe(cafeName);
  }
}
