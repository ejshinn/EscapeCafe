package bitc.fullstack405.team2.notice;

import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface NoticeService {
//    List<NoticeDTO> selectNoticeList() throws Exception;
    Page<NoticeDTO> selectNoticeList(int pageNum) throws Exception;

    NoticeDTO selectNoticeDetail(int noticeId) throws Exception;

    void updateHitCount(int noticeId) throws Exception;

    int getCafeIdByName(String name) throws Exception;

    void insertNotice(NoticeDTO notice, MultipartFile uploadFile) throws Exception;

    void deleteNotice(int noticeId) throws Exception;

    void updateNotice(NoticeDTO notice, MultipartFile uploadFile) throws Exception;

    List<NoticeDTO> selectFAQ() throws Exception;

    int getPreviousPost(int noticeId) throws Exception;

    int getNextPost(int noticeId) throws Exception;
}
