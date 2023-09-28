package productservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productservice.dto.CategoryDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.services.ProductService;
import productservice.thirdpartyclients.FakeStoreProductDto;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProducts(@PathVariable ("id")Long id) throws NotFoundException {
        ResponseEntity<ProductDto> responseEntity =
                new ResponseEntity<>(productService.getProductById(id), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @GetMapping
    public List<ProductDto> getProductList(){
        return productService.getProductList();
    }



    @GetMapping("/category/{categoryName}")
    public List<ProductDto> getProductsByCategory(@PathVariable("categoryName") String categoryName){
        return productService.getProductsByCategory(categoryName);
    }

}
