package productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import productservice.models.Category;
import productservice.models.Price;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericProductDto {
    private Long id;
    private String title;
    private String category;
    private String description;
    private double price;
    private String image;
}
