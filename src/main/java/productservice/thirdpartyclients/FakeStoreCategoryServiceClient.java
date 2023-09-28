package productservice.thirdpartyclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreCategoryServiceClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreCategoryServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<String> getAllCategories(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/categories",String[].class);

        List<String> categories = List.of(responseEntity.getBody());
        return categories;
//        List<CategoryDto> categoryDtos = new ArrayList<>();
//
//        for(String s : categories){
//            CategoryDto categoryDto = new CategoryDto();
//            categoryDto.setName(s);
//
//            categoryDtos.add(categoryDto);
//        }
//        return categoryDtos;
    }
}
