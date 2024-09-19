package bitc.fullstack405.team2.notice;

import lombok.Data;

// notice 테이블과 데이터를 주고 받기 위한 DTO 클래스
@Data
public class NoticeDTO {
    private int noticeId;
    private String category;
    private String title;
    private String createdAt;
    private String startDate;
    private String endDate;
    private String noticeImage;
    private int cafeId;
    private int hitCnt;
    private String name;
    private int previousPost;
    private int nextPost;

    private String faqId;
    private String content;
}