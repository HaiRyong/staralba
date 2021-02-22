package co.kr.staralba.web.dto.startalk;

import co.kr.staralba.domain.startalk.Startalk;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StartalkListResponseDto {
    private Long id;
    private String author;
    private String title;
    private String password;
    private String content;
    private Long cnt;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public StartalkListResponseDto(Startalk entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
