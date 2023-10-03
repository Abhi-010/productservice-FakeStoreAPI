package productservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import productservice.dto.CategoryDto;
import productservice.dto.CreateProductDto;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.models.Category;
import productservice.models.Price;
import productservice.models.Product;
import productservice.repository.CategoryRepository;
import productservice.repository.PriceRespository;
import productservice.repository.ProductRepository;
import productservice.thirdpartyclients.FakeStoreProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRespository priceRespository;

    public SelfProductServiceImpl(ProductRepository productRepository,
                                  CategoryRepository categoryRepository,PriceRespository priceRespository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRespository = priceRespository;
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
            productDto.setCategory(product1.getCategory().getName());
            productDto.setPrice(product1.getPrice().getPrice());
            productDto.setImage(product1.getImage());
            return productDto;

    }

    @Override
    public List<ProductDto> getProductList() {
        List<Product> productList = productRepository.findAll();

        List<ProductDto> productDtoList = new ArrayList<>();

        for(Product p : productList){
            ProductDto productDto = new ProductDto();
            productDto.setPrice(p.getPrice().getPrice());
            productDto.setDescription(p.getDescription());
            productDto.setTitle(p.getTitle());

            productDtoList.add(productDto);
        }
        return productDtoList;
    }
    
    @Override
    public List<GenericProductDto> getProductsByCategory(String categoryName) {

        Optional<Category> category =
                categoryRepository.findDistinctByNameEquals(categoryName);
        List<Product> productList = new ArrayList<>();
        if(!category.isEmpty()){
            productList = category.get().getProduct();
        }

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for(Product p: productList){
            genericProductDtos.add(convertProductToGenericProductDto(p));
        }
        return genericProductDtos;
    }


    @Override
    public GenericProductDto createProduct(ProductDto productDto) {

        //title,image,description..

        Category categoryToSet = new Category();

        Optional<Category> category
                = categoryRepository.findDistinctByNameEquals(productDto.getCategory());

        if(category.isEmpty()){
            categoryToSet.setName(productDto.getCategory());
        }
        else{
            categoryToSet = category.get();
        }

        Price priceToSet = new Price();
        Optional<Price> price = priceRespository.findByPrice(productDto.getPrice());

        if(price.isEmpty()){
            priceToSet.setPrice(productDto.getPrice());
        }
        else{
            priceToSet = price.get();
        }

        Product saveProduct = new Product();
        saveProduct.setDescription(productDto.getDescription());
        saveProduct.setImage(productDto.getImage());
        saveProduct.setTitle(productDto.getTitle());
        saveProduct.setCategory(categoryToSet);
        saveProduct.setPrice(priceToSet);

        Product product1 = productRepository.save(saveProduct);

         return convertProductToGenericProductDto(product1);


    }

    public GenericProductDto convertProductToGenericProductDto(Product product){
         GenericProductDto genericProductDto = new GenericProductDto();
         genericProductDto.setId(product.getId());
         genericProductDto.setTitle(product.getTitle());
         genericProductDto.setDescription(product.getDescription());
         genericProductDto.setImage(product.getImage());
         genericProductDto.setPrice(product.getPrice().getPrice());
         genericProductDto.setCategory(product.getCategory().getName());
         return genericProductDto;
    }

    public ProductDto convertProductToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setImage(product.getImage());
        productDto.setCategory(productDto.getCategory());
        productDto.setTitle(product.getTitle());
        productDto.setCategory(product.getCategory().getName());
        productDto.setPrice(product.getPrice().getPrice());
        return productDto;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {

         Optional<Product> product = productRepository.findById(id);

         GenericProductDto genericProductDto =
                 convertProductToGenericProductDto(product.get());
         productRepository.deleteById(id);
         return genericProductDto;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
