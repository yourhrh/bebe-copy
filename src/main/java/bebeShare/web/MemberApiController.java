package bebeShare.web;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.service.UserService;
import bebeShare.web.userDto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/members")
@RestController
public class MemberApiController {

    private final UserService userService;


    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/shareInfo")
    public Page<ShareInfoResponseDto> shareInfo(@RequestBody UserRequest userRequest, @LoginUser SessionUser sessionUser) {
        return userService.shareInfo(userRequest, PageRequest.of(userRequest.getPage(), userRequest.getSize()));
    }


    @GetMapping("/giveInfo")
    public Page<GiveInfoResponseDto> giveInfo(@RequestBody UserRequest userRequest, @LoginUser SessionUser sessionUser) {
        PageRequest pageRequest = PageRequest.of(userRequest.getPage(), userRequest.getSize());
        return userService.giveInfo(userRequest, pageRequest);
    }


    @GetMapping("/likeInfo")
    public Page<LikeInfoResponseDto> likeInfo(@RequestBody UserRequest userRequest, @LoginUser SessionUser sessionUser) {
        PageRequest pageRequest = PageRequest.of(userRequest.getPage(), userRequest.getSize());
        return userService.likeInfo(userRequest, pageRequest);
    }


    @GetMapping("/comments")
    public Page<MemberCommentResponseDto> comments(@RequestBody UserRequest userRequest, @LoginUser SessionUser sessionUser) {
        PageRequest pageRequest = PageRequest.of(userRequest.getPage(), userRequest.getSize());
        return userService.comments(userRequest, pageRequest);
    }

}
