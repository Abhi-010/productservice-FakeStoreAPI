package productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order extends BaseModel{


    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToMany
    @JoinTable(name = "product_oder",
    joinColumns = @JoinColumn(name = "orderr_id"),
    inverseJoinColumns = @JoinColumn(name = "productt_id"))
    private List<Product> productList;

}
