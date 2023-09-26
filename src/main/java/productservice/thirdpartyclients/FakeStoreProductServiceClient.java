package productservice.thirdpartyclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import productservice.models.Product;

@Service
public class FakeStoreProductServiceClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        System.out.println("fake Store Product DTOOOO " + fakeStoreProductDto);
        return fakeStoreProductDto;
    }

}
