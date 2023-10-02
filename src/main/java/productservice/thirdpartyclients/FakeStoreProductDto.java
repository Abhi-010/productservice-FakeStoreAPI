package productservice.thirdpartyclients;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import productservice.models.Category;
import productservice.models.Price;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Price price;
    private Category category;
    private String description;
    private String image;
    private FakeStoreRatingDto rating ;
}
