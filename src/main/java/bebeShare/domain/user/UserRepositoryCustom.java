package bebeShare.domain.user;

import bebeShare.web.userDto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {

    List<ShareInfoResponseDto> shareInfo(UserRequest userRequest);

    List<GiveInfoResponseDto> giveInfo(UserRequest conduserRequestition);

    List<LikeInfoResponseDto> likeInfo(UserRequest userRequest );

    List<MemberCommentResponseDto> comments(UserRequest condition );


}
