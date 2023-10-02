package productservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import productservice.dto.CategoryDto;
import productservice.dto.CreateProductDto;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.models.Category;
import productservice.models.Product;
import productservice.repository.ProductRepository;
import productservice.thirdpartyclients.FakeStoreProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    public SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public ProductDto getProductById(Long id) throws NotFoundException {
            Optional<Product> product =
                    productRepository.findById(id);
            if(!product.isPresent()){
                throw  new NotFoundException("id is not present");
            }
            Product product1 = product.get();

            ProductDto productDto = new ProductDto();
            productDto.setTitle(product1.getTitle());
            productDto.setDescription(product1.getDescription());
            //productDto.setCategory(product1.getCategory());
            productDto.setPrice(product1.getPrice());
            return productDto;

    }

    @Override
    public List<ProductDto> getProductList() {
        List<Product> productList = productRepository.findAll();

        List<ProductDto> productDtoList = new ArrayList<>();

        for(Product p : productList){
            ProductDto productDto = new ProductDto();
            productDto.setPrice(p.getPrice());
            productDto.setDescription(p.getDescription());
            productDto.setTitle(p.getTitle());

            productDtoList.add(productDto);
        }
        return productDtoList;
    }
    
    @Override
    public List<ProductDto> getProductsByCategory(Category categoryName) {

//        Category category = new Category();
//        category.setName(categoryName);
        List<Product> productList =
                productRepository.findProductByCategory(categoryName);

        List<ProductDto> productDtoList = new ArrayList<>();
        System.out.println("size of product DTOOOO" + productDtoList.size());

        for(Product p : productList){
            ProductDto productDto = new ProductDto();
            productDto.setCategory(p.getCategory().toString());
            productDto.setTitle(p.getTitle());
            productDto.setPrice(p.getPrice());
            productDto.setDescription(p.getDescription());

            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    @Override
    public CreateProductDto createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteProductById(Long id) {

         productRepository.deleteById(id);
        System.out.println("Product is deleted.. !!");
         return null;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
