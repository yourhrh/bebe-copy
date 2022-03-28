package bebeShare.domain.user;

import bebeShare.web.userDto.GiveInfoResponseDto;
import bebeShare.web.userDto.LikeInfoResponseDto;
import bebeShare.web.userDto.MemberCommentResponseDto;
import bebeShare.web.userDto.ShareInfoResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);


    @Query("select new bebeShare.web.userDto.ShareInfoResponseDto(p) from Product p join p.user u where u.id = :memberId AND  p.productStatus = :productStatus")
    List<ShareInfoResponseDto> shareInfo(@Param("memberId") long memberId , @Param("productStatus") String productStatus);


    @Query("select new bebeShare.web.userDto.GiveInfoResponseDto(p) from Product p join p.user u where p.shareId = :memberId AND  p.productStatus = :productStatus")
    List<GiveInfoResponseDto> giveInfo(@Param("memberId") long memberId , @Param("productStatus") String productStatus);

    @Query("select new bebeShare.web.userDto.LikeInfoResponseDto(p) from Dibs d join d.product p join d.user u where u.id =:memberId")
    List<LikeInfoResponseDto> likeInfo(@Param("memberId") long memberId);

    @Query("select new bebeShare.web.userDto.MemberCommentResponseDto(c) from Comment c join c.product p where c.user.id = :memberId")
    List<MemberCommentResponseDto> comments(@Param("memberId") long memberId);

}
