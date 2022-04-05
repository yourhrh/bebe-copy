package bebeShare.web.userDto;

import bebeShare.domain.product.Product;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class ShareInfoResponseDto {

    private Long productId;
    private String productName;
    private String productImage1;
    private LocalDateTime insertDt;

    public ShareInfoResponseDto(Long productId, String productName,LocalDateTime createDate) {
        this.productId = productId;
        this.productName   = productName;
        this.insertDt      = createDate;
    }

    public ShareInfoResponseDto(Product product) {
        this.productId = product.getId();
        this.productName   = product.getProductName();
        this.productImage1   = product.getProductImage1();
        this.insertDt      = product.getCreatedDate();
    }

}
