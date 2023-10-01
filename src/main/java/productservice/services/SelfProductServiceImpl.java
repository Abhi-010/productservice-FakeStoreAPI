package productservice.services;

import productservice.dto.CategoryDto;
import productservice.dto.CreateProductDto;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.thirdpartyclients.FakeStoreProductDto;

import java.util.List;

public class SelfProductServiceImpl implements ProductService {

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> getProductList() {
        return null;
    }


    @Override
    public List<ProductDto> getProductsByCategory(String categoryName) {
        return null;
    }

    @Override
    public CreateProductDto createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
