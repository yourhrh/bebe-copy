package bebeShare.web.dto;


import bebeShare.domain.comment.Comment;
import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CommentUpdateRequestsDto {
    private Long productId;
    private Long memberId;
    private String commentContent;

    @Builder
    public Comment toEntity(User user, Product product){
        return Comment.builder()
                .user(user)
                .product(product)
                .commentContent(commentContent)
                .deleteYn("N")
                .commentStatus("100")
                .build();
    }

}
