package co.kr.staralba.web.dto.notice;

import co.kr.staralba.domain.notice.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeListResponseDto {
    private Long id;
    private String author;
    private String title;
    private String password;
    private String content;
    private Long cnt;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public NoticeListResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
