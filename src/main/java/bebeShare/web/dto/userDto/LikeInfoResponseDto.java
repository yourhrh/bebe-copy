package bebeShare.web.dto.userDto;

import bebeShare.domain.product.Product;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class LikeInfoResponseDto {

    private Long Id;
    private String productName;
    private String productImage1;
    private String productImage2;
    private String productImage3;
    private LocalDateTime insertDt;


    public LikeInfoResponseDto(Product product) {
        this.Id = product.getId();
        this.productName   = product.getProductName();
        this.productImage1 = product.getProductImage1();
        this.productImage2 = product.getProductImage2();
        this.productImage3 = product.getProductImage3();
        this.insertDt      = product.getCreatedDate();
    }

}
