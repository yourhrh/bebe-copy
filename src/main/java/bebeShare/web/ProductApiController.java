package bebeShare.web;

import bebeShare.exception.CustomException;
import bebeShare.exception.ErrorCode;
import bebeShare.service.ProductService;
import bebeShare.web.dto.PostsResponseDto;
import bebeShare.web.dto.ProductCreateRequestDto;
import bebeShare.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    // 상품 게시글 등록
    @PostMapping("/products")
    public Long save(@RequestBody final ProductCreateRequestDto params) {
        return productService.save(params);
    }

    // 상품 게시글 조회
    @GetMapping("/products")
    public List<ProductResponseDto> findAll() {
        return productService.findAll();
    }

    // 상품 게시글 수정
    @PatchMapping("/products/{productId}")
    public Long save(@PathVariable final Long productId, @RequestBody final ProductCreateRequestDto params) {
        return productService.update(productId, params);
    }

    // 예외 발생
    @GetMapping("/test")
    public String test() {
        throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
    }
}
