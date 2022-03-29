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

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
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

        User initUser2 = userRepository.save(User.builder()
                .name("test")
                .picture("/fake/path")
                .email("test@naver.com")
                .role(Role.USER)
                .build()
        );

        User initUser3 = userRepository.save(User.builder()
                .name("test")
                .picture("/fake/path")
                .email("test@naver.com")
                .role(Role.USER)
                .build()
        );


        Product product = new Product();

        for(int i=0; i< 5; i++){
            productRepository.save(Product.builder()
                            .user(initUser)
                            .productName("product"+i)
                            .productContent("content"+i)
                            .productImage1("/fake/path" +i)
                            .productImage2("/fake2/path" +i)
                            .productImage3("/fake3/path" +i)
                            .productStatus("S")
                            .productCategory("100")
                            .deleteYn("N")
                            .build());
        }

        productRepository.save(Product.builder()
                .user(initUser2)
                .productName("product")
                .productContent("content")
                .productImage1("/fake/path")
                .productStatus("N")
                .productCategory("100")
                .deleteYn("Y")
                .build());

        productRepository.save(Product.builder()
                .user(initUser3)
                .productName("product")
                .productContent("content")
                .productImage1("/fake/path")
                .productStatus("C")
                .productCategory("100")
                .deleteYn("N")
                .build());

        Product dibsProduct = productRepository.save(Product.builder()
                .user(initUser3)
                .productName("product")
                .productContent("content")
                .productImage1("/fake/path")
                .productStatus("S")
                .productCategory("100")
                .deleteYn("N")
                .build());

        Product commentProduct = productRepository.save(Product.builder()
                .user(initUser3)
                .productName("product")
                .productContent("content")
                .productImage1("/fake/path")
                .productStatus("C")
                .productCategory("100")
                .deleteYn("N")
                .build());


        dibsRepository.save(Dibs.builder()
                        .user(initUser2)
                        .product(dibsProduct)
                .build());

        commentRepository.save(
                Comment.builder()
                        .user(initUser3)
                        .product(commentProduct)
                        .commentContent("tset !!!")
                        .deleteYn("N")
                        .commentStatus("100").build()
        );
    }
}
