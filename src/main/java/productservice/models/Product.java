package productservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;

}
