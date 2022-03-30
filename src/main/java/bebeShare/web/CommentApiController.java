package bebeShare.web;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.service.CommentsService;
import bebeShare.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentsService commentsService;

    @PostMapping("/products/{productId}/comments")
    public CommentResponseDto save(@PathVariable Long productId, @RequestBody CommentSaveRequestsDto requestsDto,
                                   @LoginUser SessionUser sessionUser) {
        requestsDto.setProductId(productId);
        requestsDto.setMemberId(sessionUser.getId());
        return commentsService.save(requestsDto);
    }

    @PatchMapping("/products/{productId}/comments/{commentId}")
    public CommentUpdateResponseDto update(@PathVariable Long productId, @PathVariable Long commentId, @RequestBody CommentUpdateRequestsDto updateRequestsDto) {
        return commentsService.update(productId, commentId, updateRequestsDto);
    }

    @DeleteMapping("/products/{productId}/comments/{commentId}")
    public CommentDeleteResponseDto delete(@PathVariable Long productId, @PathVariable Long commentId) {
        return commentsService.delete(productId, commentId);
    }
}
