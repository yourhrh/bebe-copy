package bebeShare.web.dto.userDto;

import bebeShare.domain.product.Product;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class GiveInfoResponseDto {

    private Long productId;
    private String productName;
    private String productImage1;
    private LocalDateTime insertDt;


    public GiveInfoResponseDto(Product product) {
        this.productId = product.getId();
        this.productName   = product.getProductName();
        this.productImage1 = product.getProductImage1();
        this.insertDt      = product.getCreatedDate();
    }

}
