package productservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productservice.dto.CategoryDto;
import productservice.dto.CreateProductDto;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.models.Category;
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


    @GetMapping("/category")
    public List<ProductDto> getProductsByCategory(@RequestBody Category categoryName) throws NotFoundException {
        System.out.println("you are in product controller.....");
        return productService.getProductsByCategory(categoryName);
    }


    @PostMapping
    public CreateProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> deleteProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.deleteProductById(id),
                HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<GenericProductDto> updateProduct(@PathVariable("id") Long id,
            @RequestBody GenericProductDto genericProductDto) throws NotFoundException {

        return new ResponseEntity<>(productService.updateProduct(id,genericProductDto),
                HttpStatus.NOT_FOUND);
        //return productService.updateProduct(id, genericProductDto);

    }
}
