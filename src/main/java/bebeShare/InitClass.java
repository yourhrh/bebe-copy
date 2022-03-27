package bebeShare;


import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
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



    @PostConstruct
    public void init(){

        User initUser = userRepository.save(User.builder()
                .name("test")
                .picture("/fake/path")
                .email("test@naver.com")
                .build()
        );


        Product product = new Product();

        for(int i=0; i< 5; i++){
            productRepository.save(Product.builder()
                            .user(initUser)
                            .productName("product"+i)
                            .productContent("content"+i)
                            .productImage1("/fake/path" +i)
                            .productStatus("S")
                            .productCategory("100")
                            .build());
        }
    }
}
