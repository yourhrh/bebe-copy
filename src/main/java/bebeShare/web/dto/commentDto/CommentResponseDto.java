package bebeShare.web.dto.commentDto;

import lombok.Getter;

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
