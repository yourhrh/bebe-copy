package bebeShare.web.dto.commentDto;

import bebeShare.domain.common.entity.ResEntity;
import lombok.Getter;

@Getter
public class CommentResponseDto extends ResEntity {

    private String resultCode;
    private String resultMsg;
    private Long productId;

    public CommentResponseDto(Long productId) {
        this.setResultCode("000");
        this.setResultMsg("댓글 등록 성공");
        this.productId = productId;
    }
}
