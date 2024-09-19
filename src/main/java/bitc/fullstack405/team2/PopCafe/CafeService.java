package bitc.fullstack405.team2.PopCafe;

import java.util.List;

public interface CafeService {

    List<CafeDTO> selectCafeList() throws Exception;

    CafeDTO selectCafe(int cafeId) throws Exception ;
}
