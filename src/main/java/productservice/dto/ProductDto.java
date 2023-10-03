package productservice.dto;

import lombok.Getter;
import lombok.Setter;
import productservice.models.Category;
import productservice.models.Price;

@Getter
@Setter
public class ProductDto {

    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
