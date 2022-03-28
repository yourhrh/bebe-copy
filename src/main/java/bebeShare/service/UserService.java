package bebeShare.service;

import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import bebeShare.web.userDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new UserResponseDto(entity);
    }

    public List<ShareInfoResponseDto> shareInfo(Long id) {
        return userRepository.shareInfo(id, "S");
    }

    public List<GiveInfoResponseDto> giveInfo(Long id) {
        return userRepository.giveInfo(id, "C");
    }

    public List<LikeInfoResponseDto> likeInfo(Long id) {
        return userRepository.likeInfo(id);
    }

    public List<MemberCommentResponseDto> comments(Long id) {
        return userRepository.comments(id);
    }
}
