package bebeShare.web.dto.commentDto;

import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {

    private String resultCode;
    private String resultMsg;
    private Long productId;

    public CommentUpdateResponseDto(Long productId) {
        this.resultCode = "000";
        this.resultMsg = "댓글 수정 성공";
        this.productId = productId;
    }
}