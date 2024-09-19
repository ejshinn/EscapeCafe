package bitc.fullstack405.team2.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    // 회원가입 시 아이디 중복 체크
    int idCheck(String userId) throws Exception;

    // 회원가입
    void insertUser(UserDTO user) throws Exception;

    // 사용자 로그인 여부 확인
    int isUserInfo(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;

    // 사용자 정보 가져오기
    UserDTO getUserInfo(@Param("userId") String userId) throws Exception;

    // 사용자 포인트 증가
    void updateUserPoints700(@Param("userId") String userId) throws Exception;
    void updateUserPoints300(@Param("userId") String userId) throws Exception;
}