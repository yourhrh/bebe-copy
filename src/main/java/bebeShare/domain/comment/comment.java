package bebeShare.domain.comment;


import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class comment {

    @Id
    @GeneratedValue
    @Column(name = "commentId")
    private Long Id;



    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "memberId")
    private User user;

    private String commentContent;

    private String deleteYn;

    private String commentStatus;



}
