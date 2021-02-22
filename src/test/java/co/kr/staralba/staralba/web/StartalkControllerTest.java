package co.kr.staralba.staralba.web;

import co.kr.staralba.domain.startalk.StartalkRepository;
import co.kr.staralba.service.StartalkService;
import co.kr.staralba.web.dto.startalk.StartalkSaveRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;


@SpringBootTest
public class StartalkControllerTest {
    @Autowired
    StartalkRepository startalkRepository;
    StartalkService startalkService;
    @Test
    public void save() {
        IntStream.range(1, 101).forEach(i -> {
            String title = "title"+i;
            String content = "content"+i;
            StartalkSaveRequestDto requestDto = StartalkSaveRequestDto.builder()
                    .title(title)
                    .content(content)
                    .author("author")
                    .build();
        });
    }
}