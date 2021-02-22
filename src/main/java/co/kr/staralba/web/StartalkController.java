package co.kr.staralba.web;

import co.kr.staralba.domain.startalk.Startalk;
import co.kr.staralba.service.StartalkService;
import co.kr.staralba.web.dto.startalk.StartalkResponseDto;
import co.kr.staralba.web.dto.startalk.StartalkSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@AllArgsConstructor
public class StartalkController {

    private final StartalkService startalkService;

    @PostMapping("/startalk/posts")
    public String  write(StartalkSaveRequestDto startalkSaveRequestDto, @AuthenticationPrincipal User user) {
        String user_id = user.getUsername();
        startalkSaveRequestDto.setAuthor(user_id);
        log.info("user_id: "+ user_id);
        log.info("startalkDto: " + startalkSaveRequestDto);
        startalkService.savePost(startalkSaveRequestDto);
        return "redirect:/startalk/list";
    }

    /*@PostMapping("/startalk/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody StartalkUpdateRequestDto requestDto) {
        return startalkService.update(id, requestDto);
    }

    @DeleteMapping("/startalk/posts/{id}")
    public Long delete(@PathVariable Long id) {
        startalkService.delete(id);
        return id;
    }*/

    @GetMapping("/startalk/list")
    public String startalkPage(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        //log.info("[GET] boardPage");

        Page<Startalk> findStartalk = startalkService.findPage(pageable);
        Long total = startalkService.count();
        model.addAttribute("startalkList", findStartalk);
        model.addAttribute("startalkTotal", total);
        return "startalk_list";
    }

    @GetMapping("/startalk/posts/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        StartalkResponseDto startalkResponseDto = startalkService.findById(id);
        model.addAttribute("startalkDto", startalkResponseDto);
        return "startalk_view";
    }
    /*@GetMapping("/startalk/list")
    public List<StartalkListResponseDto> findAll() {
        return startalkService.findAllDesc();
    }*/
}
