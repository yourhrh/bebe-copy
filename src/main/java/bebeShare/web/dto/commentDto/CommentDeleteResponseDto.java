package bebeShare.web.dto.commentDto;

import lombok.Getter;

@Getter
public class CommentDeleteResponseDto {

    private String resultCode;
    private String resultMsg;
    private Long productId;

    public CommentDeleteResponseDto(Long productId) {
        this.resultCode = "000";
        this.resultMsg = "댓글 삭제 성공";
        this.productId = productId;
    }
}
