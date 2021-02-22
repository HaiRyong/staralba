package co.kr.staralba.service;

import co.kr.staralba.domain.notice.Notice;
import co.kr.staralba.domain.notice.NoticeRepository;
import co.kr.staralba.web.dto.notice.NoticeResponceDto;
import co.kr.staralba.web.dto.notice.NoticeSaveRequestDto;
import co.kr.staralba.web.dto.notice.NoticeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public Long save(NoticeSaveRequestDto requestDto) {
        return noticeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, NoticeUpdateRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        notice.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        noticeRepository.delete(notice);
    }

    @Transactional(readOnly = true)
    public NoticeResponceDto findById(Long id) {
        Notice entity = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new NoticeResponceDto(entity);
    }

    /*@Transactional(readOnly = true)
    public List<NoticeListResponseDto> findAllDesc() {
        return noticeRepository.findAllDesc().stream()
                .map(NoticeListResponseDto::new)
                .collect(Collectors.toList());
    }*/
    @Transactional(readOnly = true)
    public Page<Notice> findPage(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
}
