package co.kr.staralba.domain.notice;

import co.kr.staralba.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Notice extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Column(insertable = false,
            updatable = false,
            columnDefinition = "number default 0")
    private Long cnt;

    @Builder
    public Notice(Long id, String author, String title, String password, String content, Long cnt){
        this.id = id;
        this.title = title;
        this.password = password;
        this.content = content;
        this.author = author;
        this.cnt = cnt;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
