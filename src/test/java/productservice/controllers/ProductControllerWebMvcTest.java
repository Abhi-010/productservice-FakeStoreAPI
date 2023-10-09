package productservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PathVariable;
import productservice.dto.GenericProductDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.services.ProductService;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

//import static org.apache.el.util.MessageFactory.get;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductController.class)
//@AutoConfigureMockMvc
public class ProductControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllProductsReturnsEmptyWhenNoProduct() throws Exception {

        when(productService.getProductList()).thenReturn(new ArrayList<>());

        //ResultActions resultActions = mockMvc.perform(get("/products"));

        //resultActions.andExpect(status().is(200));

        mockMvc.perform(get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void returnListOfProductsWhenProductExist() throws Exception {
        ArrayList<ProductDto> products = new ArrayList<>();
        products.add(new ProductDto());
        products.add(new ProductDto());
        products.add(new ProductDto());

        when(productService.getProductList()).thenReturn(products);

        mockMvc.perform(get("/products"))
                .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(products)))
                .andExpect(status().isOk());
    }

    @Test
    void updateProductShouldReturnUpdatedProduct() throws Exception {
        ProductDto productToCreate = new ProductDto();
        productToCreate.setTitle("Electronics");
        productToCreate.setDescription("Phone of 2023");
        productToCreate.setPrice(1232);
        productToCreate.setCategory("Phone");
        productToCreate.setImage("url_phone_electronics");

        GenericProductDto updatedProduct = new GenericProductDto();

        updatedProduct.setTitle("Electronics");
        updatedProduct.setDescription("Phone of 2023");
        updatedProduct.setPrice(1232);
        updatedProduct.setCategory("Phone");
        updatedProduct.setImage("url_phone_electronics");

        when(productService.createProduct(any())).thenReturn(updatedProduct);

        mockMvc.perform(
                        post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productToCreate))
                    )
                .andExpect(
                MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(updatedProduct))
        ).andExpect(status().isOk());
    }

    @Test
    void returnProductIfProductExist() throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setTitle("title");
        productDto.setPrice(111);
        productDto.setImage("image");

        when(productService.getProductById(any())).thenReturn(productDto);

        mockMvc.perform(get("/products/id"))
                .andExpect(MockMvcResultMatchers.content().string("productDto"));

    }
}
