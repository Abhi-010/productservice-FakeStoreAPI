package productservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
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
    public FakeStoreProductDto getProductById( Long id) {
        return fakeStoreProductServiceClient.getProductById(id);
    }
}
