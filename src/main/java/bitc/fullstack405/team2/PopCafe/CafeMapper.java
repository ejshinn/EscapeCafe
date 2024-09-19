package bitc.fullstack405.team2.PopCafe;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CafeMapper {

  CafeDTO selectCafe(int cafeId) throws Exception;

  List<CafeDTO> selectCafeList() throws Exception;
}
