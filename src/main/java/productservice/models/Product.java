package productservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Product extends BaseModel {

    private String title;
    @Column(name = "image_url")
    private String image;
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Price price;



}
