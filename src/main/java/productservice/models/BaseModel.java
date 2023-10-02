package productservice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
