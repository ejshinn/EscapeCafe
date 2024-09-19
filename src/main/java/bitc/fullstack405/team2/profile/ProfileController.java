package bitc.fullstack405.team2.profile;

import bitc.fullstack405.team2.review.ReviewDTO;
import bitc.fullstack405.team2.review.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfileController {
  @Autowired
  private ProfileService profileService;

  @Autowired
  private ReviewService reviewService;

//  유저 정보 MYPAGE 가기
  @RequestMapping("/profile")
  public ModelAndView profileMain(HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("profile/profilemain");

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");

    ProfileDTO profile = profileService.selectProfile(userId);
    mv.addObject("profile", profile);

    // 유저 예약 현황 보기
    List<ProfileReservationDTO> profileList = profileService.selectProfileList(userId);
    mv.addObject("profileList", profileList);

    // 유저 예약 현황(현재)
    List<ProfileDTO> profileRv = profileService.selectProfileRv(userId);
    mv.addObject("profileRv", profileRv);

    // 유저 예약 현황(과거)
    List<ProfileDTO> profileOverRv = profileService.selectProfileOverRv(userId);
    mv.addObject("profileOverRv", profileOverRv);

//    // 유저 후기
//    // 유저가 쓴 boardIdx 찾기
//    int boardIdx = reviewService.findBoardIdxByResId(resId);
//    // boardIdx로 게시글 찾기
//    List<ReviewDTO> review = reviewService.selectReviewDetail(boardIdx);

    return mv;
  }

//  유저 정보 상세보기
  @RequestMapping("/profiledetail")
  public ModelAndView profileDetail(HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("profile/profiledetail");

    // HttpServletRequest 써서 userId 를 세션에서 받아오기
    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");

    ProfileDTO profile = profileService.selectProfileDetail(userId);
    mv.addObject("profile", profile);

    return mv;
  }

//  유저 정보 수정
  @RequestMapping("/profileedit")
  public ModelAndView profileEdit(HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("profile/profileedit");

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");

    ProfileDTO profile = profileService.selectProfileUpdate(userId);
    mv.addObject("profile", profile);

    return mv;
  }
}