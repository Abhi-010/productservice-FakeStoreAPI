package productservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable ("id")Long id) throws NotFoundException {

        ProductDto productDto = productService.getProductById(id);
        if(productDto==null){
            throw new NotFoundException("Product not exist");
        }
        return productDto;
        /*
        ResponseEntity<ProductDto> responseEntity =
                new ResponseEntity<>(productService.getProductById(id), HttpStatus.NOT_FOUND);
        return responseEntity;

         */
    }

    @GetMapping
    public List<ProductDto> getProductList(){
        return productService.getProductList();
    }


    @GetMapping("/category/{categoryName}")
    public List<GenericProductDto> getProductsByCategory(@PathVariable("categoryName") String categoryName) throws NotFoundException {
        return productService.getProductsByCategory(categoryName);
    }


    @PostMapping
    public GenericProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id){
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
