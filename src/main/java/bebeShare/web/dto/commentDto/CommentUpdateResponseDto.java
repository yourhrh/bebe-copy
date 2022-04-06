package bebeShare.web.dto.commentDto;

import bebeShare.domain.common.entity.ResEntity;
import lombok.Getter;

@Getter
public class CommentUpdateResponseDto extends ResEntity {

    private String resultCode;
    private String resultMsg;
    private Long productId;

    public CommentUpdateResponseDto(Long productId) {
        this.setResultCode("000");
        this.setResultMsg("댓글 수정 성공");
        this.productId = productId;
    }
}