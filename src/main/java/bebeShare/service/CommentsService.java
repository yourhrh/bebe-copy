package bebeShare.service;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.domain.comment.Comment;
import bebeShare.domain.comment.CommentRepository;
import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
import bebeShare.domain.user.User;
import bebeShare.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentRepository commentRepository;

    public CommentResponseDto save(CommentSaveRequestsDto requestsDto){
        System.out.println("requestsDto.getMemberId() = " + requestsDto.getMemberId());
        System.out.println("requestsDto.getProductId() : "+requestsDto.getProductId());
        commentRepository.save(requestsDto.toEntity(requestsDto.getMemberId()));
        return new CommentResponseDto(requestsDto.getProductId());
    }

    public CommentUpdateResponseDto update(Long productId,Long commentId,CommentUpdateRequestsDto updateRequestsDto){
        Optional<Comment> updateComment = commentRepository.findById(commentId);
        updateComment.ifPresent( c -> {
                if (updateRequestsDto.getCommentContent() != null){
                    c.setCommentContent(updateRequestsDto.getCommentContent());
                }
                this.commentRepository.save(c);
        });
        return new CommentUpdateResponseDto(productId);
    }

    public CommentDeleteResponseDto delete(Long productId, Long commentId){
        commentRepository.deleteById(commentId);
        return new CommentDeleteResponseDto(productId);
    }
}
