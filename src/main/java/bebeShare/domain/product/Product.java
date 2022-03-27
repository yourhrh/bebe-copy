package bebeShare.domain.product;


import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "Product")
@Entity
public class Product {

    @Id @GeneratedValue
    @Column(name = "productId")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private User user;

    private String productName;

    private String productContent;

    private String productImage1;

    private String productImage2;

    private String productImage3;

    private String productStatus;

    private String productCategory;

    private String deleteYn;

    private String shareId;


    @Builder
    public Product(User user , String productName , String productContent ,
                   String productImage1 , String productStatus , String productCategory ){
        this.user = user;
        this.productName = productName;
        this.productContent = productContent;
        this.productImage2 = productImage1;
        this.productImage3 = productImage1;
        this.productImage1 = productImage1;
        this. productStatus = productStatus;
        this.productCategory = productCategory;
    }

}


