package bebeShare.web.dto;

import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import lombok.Data;

@Data
public class ProductCreateRequestDto {
    private User user;
    private String productName;
    private String productContent;
    private String productImage1;
    private String productImage2;
    private String productImage3;
    private String productCategory;
    private String productStatus;
    private String deleteYn;


    public Product toEntity() {
        return Product.builder()
                .user(user)
                .productName(productName)
                .productCategory(productCategory)
                .productContent(productContent)
                .productImage1(productImage1)
                .productImage2(productImage2)
                .productImage3(productImage3)
                .productStatus(productStatus)
                .deleteYn(deleteYn)
                .build();
    }
}
