package productservice.thirdpartyclients;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
    private FakeStoreRatingDto rating ;
}
