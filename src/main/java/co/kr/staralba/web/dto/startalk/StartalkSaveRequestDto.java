package co.kr.staralba.web.dto.startalk;

import co.kr.staralba.domain.startalk.Startalk;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StartalkSaveRequestDto {
    private String title;
    private String password;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public Startalk toEntity() {
        Startalk startalk = Startalk.builder()
                .title(title)
                .password(password)
                .content(content)
                .author(author)
                .build();
        return startalk;
    }

    @Builder
    public StartalkSaveRequestDto(String title,String password, String content, String author, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.title = title;
        this.password = password;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

}
