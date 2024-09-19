package bitc.fullstack405.team2.notice;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private NoticeFileUtils fileUtils;

//    // notice 목록
//    @Override
//    public List<NoticeDTO> selectNoticeList() throws Exception {
//        return noticeMapper.selectNoticeList();
//    }

    @Override
    public Page<NoticeDTO> selectNoticeList(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        return noticeMapper.selectNoticeList();
    }

    // notice 게시글 세부 내용
    @Override
    public NoticeDTO selectNoticeDetail(int noticeId) throws Exception {
        return noticeMapper.selectNoticeDetail(noticeId);
    }

    // notice 조회수 증가
    @Override
    public void updateHitCount(int noticeId) throws Exception {
        noticeMapper.updateHitCount(noticeId);
    }

    @Override
    public int getCafeIdByName(String name) throws Exception {
        return noticeMapper.getCafeIdByName(name);
    }

    @Override
    public void insertNotice(NoticeDTO notice, MultipartFile uploadFile) throws Exception {
        // FileUtils에서 DB에 저장할 파일 이름 가져오기
        String noticeImage = fileUtils.parseFileInfo(uploadFile);
        notice.setNoticeImage(noticeImage);
        noticeMapper.insertNotice(notice);
    }

    @Override
    public void deleteNotice(int noticeId) throws Exception {
        noticeMapper.deleteNotice(noticeId);
    }

    @Override
    public void updateNotice(NoticeDTO notice, MultipartFile uploadFile) throws Exception {
        // FileUtils에서 DB에 저장할 파일 이름 가져오기
        String noticeImage = fileUtils.parseFileInfo(uploadFile);
        notice.setNoticeImage(noticeImage);
        noticeMapper.updateNotice(notice);
    }

    // FAQ 목록
    @Override
    public List<NoticeDTO> selectFAQ() throws Exception {
        return noticeMapper.selectFAQ();
    }

    @Override
    public int getPreviousPost(int noticeId) throws Exception {
        return noticeMapper.findPreviousPost(noticeId);
    }

    @Override
    public int getNextPost(int noticeId) throws Exception {
        return noticeMapper.findNextPost(noticeId);
    }
}