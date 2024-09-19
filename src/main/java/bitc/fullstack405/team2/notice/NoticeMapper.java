package bitc.fullstack405.team2.notice;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int getCafeIdByName(String name) throws Exception;

    void insertNotice(NoticeDTO notice) throws Exception;

//    List<NoticeDTO> selectNoticeList() throws Exception;
    Page<NoticeDTO> selectNoticeList() throws Exception;

    NoticeDTO selectNoticeDetail(int noticeId) throws Exception;

    void updateHitCount(int noticeId) throws Exception;

    void deleteNotice(int noticeId) throws Exception;

    void updateNotice(NoticeDTO notice) throws Exception;

    List<NoticeDTO> selectFAQ() throws Exception;

    int findPreviousPost(int noticeId) throws Exception;

    int findNextPost(int noticeId) throws Exception;
}