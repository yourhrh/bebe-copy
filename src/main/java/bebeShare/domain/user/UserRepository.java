package bebeShare.domain.user;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.product.Product;
import bebeShare.web.dto.userDto.UserRequest;
import bebeShare.web.dto.userDto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);


    @Query(value = "select p from Product p join p.user u where u.id = :#{#userRequest.memberId} AND  p.productStatus = :#{#userRequest.productStatus}",
            countQuery = "select count(p) from Product p join p.user u where u.id = :#{#userRequest.memberId} AND  p.productStatus = :#{#userRequest.productStatus}")
    Page<Product> shareInfo(@Param("userRequest") UserRequest userRequest, Pageable pageable);


    @Query(value = "select p from Product p join p.user u where p.shareId = :#{#userRequest.memberId} AND  p.productStatus = :#{#userRequest.productStatus}",
            countQuery = "select count(p) from Product p join p.user u where p.shareId = :#{#userRequest.memberId} AND  p.productStatus = :#{#userRequest.productStatus}")
    Page<Product> giveInfo(@Param("userRequest") UserRequest userRequest, Pageable pageable);

    @Query(value = "select p from Dibs d join d.product p join d.user u where u.id =:#{#userRequest.memberId}",
            countQuery = "select count(p) from Dibs d join d.product p join d.user u where u.id =:#{#userRequest.memberId}")
    Page<Product> likeInfo(@Param("userRequest") UserRequest userRequest, Pageable pageable);

    @Query(value = "select c from Comment c join c.product p where c.user.id = :#{#userRequest.memberId}",
            countQuery = "select count(c) from Comment c join c.product p where c.user.id = :#{#userRequest.memberId}")
    Page<Comment> comments(@Param("userRequest") UserRequest userRequest, Pageable pageable);

}
