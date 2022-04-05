package bebeShare.web.dto.commentDto;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private String resultCode;
    private String resultMsg;
    private Long productId;

    public CommentResponseDto(Long productId) {
        this.resultCode = "000";
        this.resultMsg = "댓글 등록 성공";
        this.productId = productId;
    }
}
