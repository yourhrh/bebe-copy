package bebeShare.service;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import bebeShare.web.userDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new UserResponseDto(entity);
    }

    public Page<ShareInfoResponseDto> shareInfo(UserRequest userRequest, Pageable pageable) {
        Page<Product> products = userRepository.shareInfo(userRequest, pageable);
        return products.map(ShareInfoResponseDto::new);
    }
    public Page<GiveInfoResponseDto> giveInfo(UserRequest userRequest, Pageable pageable) {
        Page<Product> products = userRepository.giveInfo(userRequest, pageable);
        return products.map(GiveInfoResponseDto::new);
    }

    public Page<LikeInfoResponseDto> likeInfo(UserRequest userRequest, Pageable pageable) {
        Page<Product> products = userRepository.likeInfo(userRequest, pageable);
        return products.map(LikeInfoResponseDto::new);
    }
    public Page<MemberCommentResponseDto> comments(UserRequest userRequest, Pageable pageable) {
        Page<Comment> comments = userRepository.comments(userRequest, pageable);
        return comments.map(MemberCommentResponseDto::new);
    }
}
