package co.kr.staralba.web.dto.notice;

import co.kr.staralba.domain.notice.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeResponceDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public NoticeResponceDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
