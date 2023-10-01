package productservice.services;

import productservice.dto.CategoryDto;
import productservice.dto.CreateProductDto;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.thirdpartyclients.FakeStoreProductDto;

import java.util.List;

public interface ProductService {

    public ProductDto getProductById(Long id) throws NotFoundException;
    public List<ProductDto> getProductList();

    public List<ProductDto> getProductsByCategory(String categoryName) throws NotFoundException;

    public CreateProductDto createProduct(ProductDto productDto);

    public ProductDto deleteProductById(Long id);

    public GenericProductDto updateProduct(Long id,GenericProductDto genericProductDto);

}
