package bebeShare.service;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.comment.CommentRepository;
import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import bebeShare.exception.CustomException;
import bebeShare.exception.ErrorCode;
import bebeShare.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    @Transactional
    public CommentResponseDto save(CommentSaveRequestsDto requestsDto) {

        User user = userRepository.findById(requestsDto.getMemberId())
                .orElseThrow( () -> new CustomException(ErrorCode.USER_NOT_FOUND));
        Product product = productRepository.findById(requestsDto.getProductId())
                .orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        
        commentRepository.save(requestsDto.toEntity(user, product));
        return new CommentResponseDto(requestsDto.getProductId());
    }

    @Transactional
    public CommentUpdateResponseDto update(Long productId, Long commentId, CommentUpdateRequestsDto updateRequestsDto) {
        commentRepository.findById(commentId).ifPresent(c -> {
            if (updateRequestsDto.getCommentContent() != null) {
                c.setCommentContent(updateRequestsDto.getCommentContent());
            }
            commentRepository.save(c);
        });
        return new CommentUpdateResponseDto(productId);
    }

    @Transactional
    public CommentDeleteResponseDto delete(Long productId, Long commentId) {
        commentRepository.deleteById(commentId);
        return new CommentDeleteResponseDto(productId);
    }
}
