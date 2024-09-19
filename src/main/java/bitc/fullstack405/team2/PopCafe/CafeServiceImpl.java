package bitc.fullstack405.team2.PopCafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeServiceImpl implements CafeService {

  @Autowired
  private CafeMapper cafeMapper;

  @Override
  public List<CafeDTO> selectCafeList() throws Exception {
    return cafeMapper.selectCafeList();
  }

  @Override
  public CafeDTO selectCafe(int cafeId) throws Exception {
    return cafeMapper.selectCafe(cafeId);
  }
}
