package bitc.fullstack405.team2.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // 회원가입 시 아이디 중복 체크, ajax 통신으로 id 값 가져옴
    @ResponseBody
    @PostMapping("/user/idCheck")
    public Object idCheck(String userId) throws Exception {
        // 사용자가 입력한 id가 있는지 DB에서 검색
        int result = userService.idCheck(userId);

        Map<String, String> mapResult = new HashMap<String, String>();
        mapResult.put("value", String.valueOf(result));

        // 해당 id가 DB에 없으면 0 반환(회원가입 가능), DB에 있으면 1 반환(아이디 중복으로 회원가입 불가능)
        return mapResult;
    }

    // 회원가입(view)
    @GetMapping("/user/register")
    public String registerUser() throws Exception {
        return "user/membership";
    }

    // 회원가입(내부처리)
    @PostMapping("/user/register")
    public String registerUser(UserDTO user) throws Exception {
        userService.insertUser(user);

        return "redirect:/user/login";
    }

    // 로그인(view)
    @GetMapping("/user/login")
    public String login() throws Exception {
        return "user/login";
    }

    // 로그인(내부 처리)
    @RequestMapping("/user/login")
    public String loginProcess(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpServletRequest req) throws Exception {
        // 사용자가 입력한 id/pw를 사용하는 사용자가 있는지 DB에서 검색
        int result = userService.isUserInfo(userId, userPw);

        if (result == 1) { // 로그인 성공
            UserDTO user = userService.getUserInfo(userId);

            // DB에서 가져온 정보를 세션에 저장
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("gender", user.getGender());
            session.setAttribute("age", user.getAge());
            session.setAttribute("mobileNumber", user.getMobileNumber());
            session.setAttribute("nickname", user.getNickname());
            session.setAttribute("point", user.getPoint());
            session.setAttribute("adminCk", user.getAdminCk());

            // 세션 유지 시간 설정
            session.setMaxInactiveInterval(60 * 60 * 1);

            // 메인 페이지로 리다이렉트
            return "redirect:/main";
        }
        else { // 로그인 실패
            return "redirect:login?loginError=invalid";
        }
    }

    // 로그아웃 처리, 세션에 저장된 모든 내용을 삭제하면 로그아웃
    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest req) throws Exception {
        // request 객체를 통해서 세션 정보를 가져옴
        HttpSession session = req.getSession();

        // 세션에 저장된 정보를 삭제
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("nickname");
        session.removeAttribute("email");
        session.removeAttribute("gender");
        session.removeAttribute("age");
        session.removeAttribute("mobileNumber");
        session.removeAttribute("nickname");
        session.removeAttribute("point");
        session.removeAttribute("adminCk");

        // 모든 세션 정보 삭제
        session.invalidate();

        // 메인 페이지로 리다이렉트
        return "redirect:/main";
    }
}
