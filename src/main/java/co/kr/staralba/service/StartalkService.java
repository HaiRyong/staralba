package co.kr.staralba.service;


import co.kr.staralba.domain.startalk.Startalk;
import co.kr.staralba.domain.startalk.StartalkRepository;
import co.kr.staralba.web.dto.startalk.StartalkResponseDto;
import co.kr.staralba.web.dto.startalk.StartalkSaveRequestDto;
import co.kr.staralba.web.dto.startalk.StartalkUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Log4j2
@AllArgsConstructor
@Service
public class StartalkService {
    private final StartalkRepository startalkRepository;

    @Transactional
    public Long savePost(StartalkSaveRequestDto startalkSaveRequestDto) {
        return startalkRepository.save(startalkSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, StartalkUpdateRequestDto requestDto) {
        Startalk startalk = startalkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        startalk.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Startalk startalk = startalkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        startalkRepository.delete(startalk);
    }

    @Transactional(readOnly = true)
    public StartalkResponseDto findById(Long id) {
        Startalk entity = startalkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new StartalkResponseDto(entity);
    }

   /* @Transactional(readOnly = true)
    public List<StartalkListResponseDto> findAllDesc() {
        return startalkRepository.findAllDesc().stream()
                .map(StartalkListResponseDto::new)
                .collect(Collectors.toList());
    }*/

    // 페이지로 가져오기
    @Transactional(readOnly = true)
    public Page<Startalk> findPage(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return startalkRepository.findAll(pageable);
    }
    public Long count() {
        return startalkRepository.count();
    }
}

