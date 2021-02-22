package co.kr.staralba.domain.startalk;

import co.kr.staralba.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "startalk")
public class Startalk extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 10, nullable = false)
    private String author;

    @Column(insertable = false,
            updatable = false,
            columnDefinition = "number default 0")
    private Long cnt;

    @Builder
    public Startalk(Long id, String author, String title, String password, String content){
        this.id = id;
        this.title = title;
        this.password = password;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
