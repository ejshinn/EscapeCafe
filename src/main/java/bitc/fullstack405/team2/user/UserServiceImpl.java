package bitc.fullstack405.team2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(UserDTO user) throws Exception {
        userMapper.insertUser(user);
    }

    @Override
    public int isUserInfo(String userId, String userPw) throws Exception {
        return userMapper.isUserInfo(userId, userPw);
    }

    @Override
    public UserDTO getUserInfo(String userId) throws Exception {
        return userMapper.getUserInfo(userId);
    }

    @Override
    public int idCheck(String userId) throws Exception {
        return userMapper.idCheck(userId);
    }
}
