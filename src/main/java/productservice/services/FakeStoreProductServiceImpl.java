package productservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import productservice.dto.CategoryDto;
import productservice.dto.CreateProductDto;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.models.Category;
import productservice.thirdpartyclients.FakeStoreProductDto;
import productservice.thirdpartyclients.FakeStoreProductServiceClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    FakeStoreProductServiceClient fakeStoreProductServiceClient;
    public FakeStoreProductServiceImpl(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }
    @Override
    public ProductDto getProductById(Long id) throws NotFoundException {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.getProductById(id);

        ProductDto productDto = new ProductDto();
      //  productDto.setCategory(fakeStoreProductDto.getCategory());
        productDto.setTitle(fakeStoreProductDto.getTitle());
        productDto.setPrice(fakeStoreProductDto.getPrice().getPrice());
        productDto.setDescription(fakeStoreProductDto.getDescription());
        return  productDto;
    }

    @Override
    public List<ProductDto> getProductList() {

        List<FakeStoreProductDto> fakeStoreProductDtos =
                fakeStoreProductServiceClient.getProductlist();


        List<ProductDto> productDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            ProductDto productDto = new ProductDto();
            productDto.setPrice(fakeStoreProductDto.getPrice().getPrice());
            productDto.setTitle(fakeStoreProductDto.getTitle());
           // productDto.setCategory(fakeStoreProductDto.getCategory());

            productDtoList.add(productDto);
        }

        return productDtoList;
    }


    @Override
    public List<GenericProductDto> getProductsByCategory(String categoryName) throws NotFoundException {
        /*
        List<FakeStoreProductDto> fakeStoreProductDtoList =
                fakeStoreProductServiceClient.getProductsByCategory(categoryName);


        List<ProductDto> productDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList){
            ProductDto productDto = new ProductDto();
            productDto.setPrice(fakeStoreProductDto.getPrice());
            productDto.setTitle(fakeStoreProductDto.getTitle());
            //productDto.setCategory(fakeStoreProductDto.getCategory());

            productDtoList.add(productDto);
        }

        return productDtoList;
        */
        return null;
    }

    @Override
    public GenericProductDto createProduct(ProductDto productDto) {
        FakeStoreProductDto fakeStoreProductDto =
                fakeStoreProductServiceClient.createProduct(productDto);
        return null;

//        ProductDto productDto1 = new ProductDto();
//        productDto1.setCategory(fakeStoreProductDto.getCategory());
//        productDto1.setId(fakeStoreProductDto.getId());
//        productDto1.setTitle(fakeStoreProductDto.getTitle());
//        productDto1.setDescription(fakeStoreProductDto.getDescription());
//        productDto1.setPrice(fakeStoreProductDto.getPrice());
//
//        return createProductDto;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto =
                fakeStoreProductServiceClient.deleteProductById(id);
        ProductDto productDto = new ProductDto();

       // productDto.setCategory(fakeStoreProductDto.getCategory());
        productDto.setTitle(fakeStoreProductDto.getTitle());
        productDto.setPrice(fakeStoreProductDto.getPrice().getPrice());
        productDto.setDescription(fakeStoreProductDto.getDescription());
        return null;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) throws NotFoundException {

        FakeStoreProductDto fakeStoreProductDto
                = fakeStoreProductServiceClient.updateProduct(id,genericProductDto);

        GenericProductDto genericProductDto1 = new GenericProductDto();

        genericProductDto1.setCategory(fakeStoreProductDto.getCategory().getName());
        genericProductDto1.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto1.setPrice(fakeStoreProductDto.getPrice().getPrice());
        genericProductDto1.setTitle(fakeStoreProductDto.getTitle());

        return genericProductDto1;
    }
}
