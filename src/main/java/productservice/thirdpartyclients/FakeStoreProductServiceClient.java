package productservice.thirdpartyclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import productservice.dto.CategoryDto;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
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


    public List<FakeStoreProductDto> getProductsByCategory(String categoryName) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/category/{categoryName}",FakeStoreProductDto[].class,categoryName);

        List<FakeStoreProductDto> fakeStoreProductDtoList = List.of(responseEntity.getBody());
        if(fakeStoreProductDtoList.isEmpty()){
            throw new NotFoundException("this category is not valid");
        }
        return fakeStoreProductDtoList;

    }

    public FakeStoreProductDto createProduct(ProductDto product){

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity("https://fakestoreapi.com/products",product,
                        FakeStoreProductDto.class);

        return responseEntity.getBody();


    }

    public FakeStoreProductDto deleteProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback =
                restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);

        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute("https://fakestoreapi.com/products/{id}",
                        HttpMethod.DELETE,
                        requestCallback, responseExtractor, id);


        return response.getBody();
    }

    public FakeStoreProductDto updateProduct(Long id, GenericProductDto genericProductDto) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback =
                restTemplate.httpEntityCallback(genericProductDto,FakeStoreProductDto.class);

        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute("https://fakestoreapi.com/products/{id}",
                        HttpMethod.PUT,
                        requestCallback, responseExtractor, id);

        if(response.getBody() == null){
            throw new NotFoundException("id is not valid");
        }
        //return response != response.getBody() : null ;
        return response.getBody();
    }

}
