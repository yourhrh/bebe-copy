package bebeShare.domain.posts;


import bebeShare.BaseEntity;
import bebeShare.web.dto.PostUpdateRequestsDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(length = 500, nullable = false) //굳이 선언하지않더라도 모두 칼럼이된다 나머지 필드는. 사용할경우 옵션을 주기위해
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(PostUpdateRequestsDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
