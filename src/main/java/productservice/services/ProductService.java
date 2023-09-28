package productservice.services;

import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.thirdpartyclients.FakeStoreProductDto;

import java.util.List;

public interface ProductService {

    public ProductDto getProductById(Long id) throws NotFoundException;
    public List<ProductDto> getProductList();
}
