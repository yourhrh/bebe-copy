package bebeShare.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestsDto {

    private String title;
    private String content;


    @Builder
    public PostUpdateRequestsDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
