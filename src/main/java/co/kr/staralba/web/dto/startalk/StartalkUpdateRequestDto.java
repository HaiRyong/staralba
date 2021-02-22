package co.kr.staralba.web.dto.startalk;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StartalkUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public StartalkUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
