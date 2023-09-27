package productservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.thirdpartyclients.FakeStoreProductDto;
import productservice.thirdpartyclients.FakeStoreProductServiceClient;

@Service
@Primary
public class FakeStoreProductServiceImpl implements ProductService {

    FakeStoreProductServiceClient fakeStoreProductServiceClient;
    public FakeStoreProductServiceImpl(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }
    @Override
    public ProductDto getProductById(Long id) throws NotFoundException {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.getProductById(id);

        ProductDto productDto = new ProductDto();
        productDto.setCategory(fakeStoreProductDto.getCategory());
        productDto.setTitle(fakeStoreProductDto.getTitle());
        productDto.setPrice(fakeStoreProductDto.getPrice());
        return  productDto;
    }
}
