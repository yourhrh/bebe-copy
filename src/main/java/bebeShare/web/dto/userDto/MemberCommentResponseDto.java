package bebeShare.web.dto.userDto;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.product.Product;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class MemberCommentResponseDto {

    private Long commentId;
    private String productName;
    private String commentContent;
    private LocalDateTime insertDt;

    public MemberCommentResponseDto(Comment comment) {
        this.commentId = comment.getId();
        this.productName   = comment.getProduct().getProductName();
        this.commentContent = comment.getCommentContent();
        this.insertDt      = comment.getCreatedDate();
    }

}
