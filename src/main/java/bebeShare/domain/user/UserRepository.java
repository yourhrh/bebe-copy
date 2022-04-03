package bebeShare.domain.user;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.product.Product;
import bebeShare.web.userDto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom, QuerydslPredicateExecutor<User> {


    Optional<User> findByEmail(String email);
}
