package productservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.services.ProductService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    @Autowired
    private ProductService productService;

    @Test
    void returnNullWhenProductDoesntExist() throws NotFoundException {
       ProductDto productDto =
                productController.getProductById(121L);

       when(productService.getProductById(1256L)).thenReturn(null);

        assertNull(productDto);
    }

    @Test
    void shouldReturnTitleNamanWithProductID1() throws NotFoundException {

        ProductDto productDto = new ProductDto();
        productDto.setTitle("Naman");

        when(productService.getProductById(1L)).thenReturn(productDto);

        ProductDto productDto1 = productController.getProductById(1L);

        assertEquals("Naman", productDto1.getTitle());

    }

    @Test
    void throwsExceptionWhenProductDoesntExist() throws NotFoundException {
        when(productService.getProductById(any(Long.class))).thenReturn(null);

        assertThrows(NotFoundException.class,()-> productController.getProductById(123L));
    }

    @Test
    void returnsProductWhenProductExist() throws NotFoundException {

      ProductDto productDto = new ProductDto();
      when(productService.getProductById(any(Long.class))).thenReturn(productDto);

      assertEquals(productDto,productController.getProductById(121L));

    }

}
