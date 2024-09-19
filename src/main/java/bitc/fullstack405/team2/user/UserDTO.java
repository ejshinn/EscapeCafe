package bitc.fullstack405.team2.user;

import lombok.Data;

// user 테이블과 데이터를 주고 받기 위한 DTO 클래스
@Data
public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String email;
    private String gender;
    private String age;
    private String mobileNumber;
    private String nickname;
    private int point;
    private int adminCk;
}