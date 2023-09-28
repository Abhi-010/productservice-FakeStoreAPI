package productservice.thirdpartyclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import productservice.dto.CategoryDto;
import productservice.exception.NotFoundException;
import productservice.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new NotFoundException("this id is not valid");
        }
        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getProductlist(){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());

        return fakeStoreProductDtos;
    }



    public List<FakeStoreProductDto> getProductsByCategory(String categoryName){

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/category/{categoryName}",FakeStoreProductDto[].class,categoryName);

        List<FakeStoreProductDto> fakeStoreProductDtoList = List.of(responseEntity.getBody());
        return fakeStoreProductDtoList;

    }

}
