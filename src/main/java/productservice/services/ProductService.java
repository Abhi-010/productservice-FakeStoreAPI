package productservice.services;

import productservice.thirdpartyclients.FakeStoreProductDto;

public interface ProductService {

    public FakeStoreProductDto getProductById(Long id);
}
