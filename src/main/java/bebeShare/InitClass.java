package bebeShare;


import bebeShare.domain.comment.Comment;
import bebeShare.domain.comment.CommentRepository;
import bebeShare.domain.like.Dibs;
import bebeShare.domain.like.DibsRepository;
import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
import bebeShare.domain.user.Role;
import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Transactional
public class InitClass {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final DibsRepository dibsRepository;
    private final CommentRepository commentRepository;



    @PostConstruct
    public void init(){

        User initUser = userRepository.save(User.builder()
                .name("test")
                .picture("/fake/path")
                .email("test@naver.com")
                .role(Role.USER)
                .build()
        );


        Product product1 = productRepository.save(Product.builder()
                .user(initUser)
                .productName("product1")
                .productContent("content1")
                .productImage1("/fake/path1")
                .productStatus("S")
                .productCategory("100")
                .deleteYn("N")
                .shareId(initUser.getId())
                .build());

        product1.addUser(initUser);


        Product product2 = productRepository.save(Product.builder()
                .user(initUser)
                .productName("product2")
                .productContent("content2")
                .productImage1("/fake/path2")
                .productStatus("N")
                .productCategory("100")
                .deleteYn("Y")
                .build());

        Product product3 = productRepository.save(Product.builder()
                .user(initUser)
                .productName("product3")
                .productContent("content3")
                .productImage1("/fake/path3")
                .productStatus("C")
                .productCategory("100")
                .deleteYn("N")
                .build());

        Product dibsProduct = productRepository.save(Product.builder()
                .user(initUser)
                .productName("product")
                .productContent("content")
                .productImage1("/fake/path")
                .productStatus("S")
                .productCategory("100")
                .deleteYn("N")
                .build());

        Product commentProduct = productRepository.save(Product.builder()
                .user(initUser)
                .productName("product")
                .productContent("content")
                .productImage1("/fake/path")
                .productStatus("C")
                .productCategory("100")
                .deleteYn("N")
                .build());


        dibsRepository.save(Dibs.builder()
                        .user(initUser)
                        .product(dibsProduct)
                .build());

        commentRepository.save(
                Comment.builder()
                        .user(initUser)
                        .product(commentProduct)
                        .commentContent("tset !!!")
                        .deleteYn("N")
                        .commentStatus("100").build()
        );
    }
}
