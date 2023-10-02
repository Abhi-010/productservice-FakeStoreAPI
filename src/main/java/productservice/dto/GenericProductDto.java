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
    private String title;
    private Price price;
    private Category category;
    private String description;
}
