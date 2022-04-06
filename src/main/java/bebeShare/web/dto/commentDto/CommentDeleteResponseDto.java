package bebeShare.web.dto.commentDto;

import bebeShare.domain.common.entity.ResEntity;
import lombok.Getter;

@Getter
public class CommentDeleteResponseDto extends ResEntity {

    private Long productId;

    public CommentDeleteResponseDto(Long productId) {
        this.setResultCode("000");
        this.setResultMsg("댓글 삭제 성공");
        this.productId = productId;
    }
}
