package co.kr.staralba.web.dto.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public NoticeUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
