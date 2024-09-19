package bitc.fullstack405.team2.notice;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // FAQ 목록 출력(view)
    @GetMapping("/notice/FAQ")
    public ModelAndView  selectFAQ() throws Exception {
        ModelAndView mv = new ModelAndView("notice/notice_FAQ");

        List<NoticeDTO> FAQList = noticeService.selectFAQ();
        mv.addObject("FAQList", FAQList);

        return mv;
    }

//    // notice 게시판 목록 출력
//    @GetMapping("/notice")
//    public ModelAndView selectNoticeList() throws Exception {
//        ModelAndView mv = new ModelAndView("notice/noticeList");
//
//        List<NoticeDTO> noticeList = noticeService.selectNoticeList();
//        mv.addObject("noticeList", noticeList);
//
//        return mv;
//    }

    // notice 게시판 목록 출력(페이징)
    @GetMapping("/notice")
    public ModelAndView selectNoticeList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("notice/noticeList");

        // noticeService.selectNoticeList(pageNum)을 호출하여 공지사항 리스트를 가져옵니다.
        List<NoticeDTO> noticeList = noticeService.selectNoticeList(pageNum);

        // PageInfo 객체를 생성하여 공지사항 리스트와 페이지 사이즈 5로 설정합니다.
        PageInfo<NoticeDTO> pageInfo = new PageInfo<>(noticeList, 5);

        // ModelAndView에 noticeList라는 이름으로 리스트 데이터를 추가합니다.
        mv.addObject("noticeList", noticeList);
        // 페이지네이션 정보를 추가합니다.
        mv.addObject("pageInfo", pageInfo);

        return mv;
    }

    // notice 게시물 상세
    @GetMapping("/notice/{noticeId}")
    public ModelAndView selectNoticeDetail(@PathVariable("noticeId") int noticeId) throws Exception {
        noticeService.updateHitCount(noticeId);

        ModelAndView mv = new ModelAndView("notice/noticeDetail");

        NoticeDTO notice = noticeService.selectNoticeDetail(noticeId); // 현재 게시물 조회
        notice.setPreviousPost(noticeService.getPreviousPost(noticeId)); // 이전 게시물 ID 조회
        notice.setNextPost(noticeService.getNextPost(noticeId)); // 다음 게시물 ID 조회

        mv.addObject("notice", notice);

        return mv;
    }

    // notice 게시글 작성(view)
    @GetMapping("/notice/write")
    public String noticeWrite() throws Exception {
        return "notice/noticeWrite";
    }

    // notice 게시글 작성(내부 처리)
    @PostMapping("/notice/write")
    public String noticeWrite(NoticeDTO notice, @RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {

        int cafeId = 0;
        
        // 지점명이 전체가 아니면 해당 지점의 id 가져오기
        if(!notice.getName().equals("전체")) {
            cafeId = noticeService.getCafeIdByName(notice.getName());
        }

        // cafeId를 notice 객체에 설정
        notice.setCafeId(cafeId);

        noticeService.insertNotice(notice, uploadFile);
        return "redirect:/notice";
    }

    // notice 게시물 삭제
    @DeleteMapping("/notice/{noticeId}")
    public String deleteNotice(int noticeId) throws Exception {
        noticeService.deleteNotice(noticeId);

        return "redirect:/notice";
    }

    // notice 게시글 수정(view)
    @GetMapping("/notice/edit/{noticeId}")
    public ModelAndView noticeEdit(@PathVariable("noticeId") int noticeId) throws Exception {
        noticeService.updateHitCount(noticeId);

        ModelAndView mv = new ModelAndView("notice/noticeEdit");

        NoticeDTO notice = noticeService.selectNoticeDetail(noticeId);
        mv.addObject("notice", notice);

        return mv;
    }

    // notice 게시물 수정(내부 처리)
    @PutMapping("/notice/edit/{noticeId}")
    public String updateNotice(@PathVariable("noticeId") int noticeId, NoticeDTO notice, @RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {
        int cafeId = 0;

        // 지점명이 전체가 아니면 해당 지점의 id 가져오기
        if(!notice.getName().equals("전체")) {
            cafeId = noticeService.getCafeIdByName(notice.getName());
        }

        // cafeId를 notice 객체에 설정
        notice.setCafeId(cafeId);
        // noticeId를 notice 객체에 설정
        notice.setNoticeId(noticeId);

        noticeService.updateNotice(notice, uploadFile);

        return "redirect:/notice";
    }
}