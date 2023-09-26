package productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productservice.services.ProductService;
import productservice.thirdpartyclients.FakeStoreProductDto;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public FakeStoreProductDto getProducts(@PathVariable ("id")Long id){
        return productService.getProductById(id);
    }
//    @GetMapping("/list")
//    public String getProductsList(){
//        return "list of products";
//    }
}
