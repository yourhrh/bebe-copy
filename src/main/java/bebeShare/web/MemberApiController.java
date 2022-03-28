package bebeShare.web;

import bebeShare.service.UserService;
import bebeShare.web.dto.PostsResponseDto;
import bebeShare.web.userDto.GiveInfoResponseDto;
import bebeShare.web.userDto.LikeInfoResponseDto;
import bebeShare.web.userDto.ShareInfoResponseDto;
import bebeShare.web.userDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/members")
@RestController
public class MemberApiController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/shareInfo")
    public List<ShareInfoResponseDto> shareInfo(@PathVariable Long id){
        return userService.shareInfo(id);
    }


    @GetMapping("/giveInfo")
    public List<GiveInfoResponseDto>  giveInfo(@PathVariable Long id){
        return userService.giveInfo(id);
    }


    @GetMapping("/likeInfo")
    public List<LikeInfoResponseDto> likeInfo(@PathVariable Long id){
        return userService.likeInfo(id);
    }



}
