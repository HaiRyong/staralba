package co.kr.staralba.web;

import co.kr.staralba.domain.notice.Notice;
import co.kr.staralba.service.NoticeService;
import co.kr.staralba.web.dto.notice.NoticeResponceDto;
import co.kr.staralba.web.dto.notice.NoticeSaveRequestDto;
import co.kr.staralba.web.dto.notice.NoticeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/notice/posts")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto) {
        return noticeService.save(requestDto);
    }
    @PutMapping("/notice/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeUpdateRequestDto requestDto) {
        return noticeService.update(id, requestDto);
    }
    @DeleteMapping("/notice/posts/{id}")
    public Long delete(@PathVariable Long id) {
        noticeService.delete(id);
        return id;
    }

    @GetMapping("/notice/posts/{id}")
    public NoticeResponceDto findById(@PathVariable Long id) {
        return noticeService.findById(id);
    }

    @GetMapping("/notice/list")
    public String noticePage(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        //log.info("[GET] boardPage");

        Page<Notice> findNotice = noticeService.findPage(pageable);

        model.addAttribute("Notices", findNotice);
        return "notice_list";
    }
}
