package co.kr.staralba.web.dto.notice;

import co.kr.staralba.domain.notice.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeSaveRequestDto {
    private String title;
    private String password;
    private String content;
    private String author;
    private Long cnt;

    @Builder
    public NoticeSaveRequestDto(String title, String password, String content, String author, Long cnt) {
        this.title = title;
        this.password = password;
        this.content = content;
        this.author = author;
        this.cnt = cnt;
    }

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .author(author)
                .cnt(cnt)
                .build();
    }
}
