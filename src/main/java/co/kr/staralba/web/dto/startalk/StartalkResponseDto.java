package co.kr.staralba.web.dto.startalk;

import co.kr.staralba.domain.startalk.Startalk;
import lombok.Getter;

@Getter
public class StartalkResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public StartalkResponseDto(Startalk entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
