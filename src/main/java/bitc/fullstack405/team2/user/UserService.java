package bitc.fullstack405.team2.user;

public interface UserService {
    void insertUser(UserDTO user) throws Exception;

    int isUserInfo(String userId, String userPw) throws Exception;

    UserDTO getUserInfo(String userId) throws Exception;

    int idCheck(String userId) throws Exception;
}
