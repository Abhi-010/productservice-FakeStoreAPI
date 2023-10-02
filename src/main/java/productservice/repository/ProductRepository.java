package productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productservice.dto.ProductDto;
import productservice.models.Product;

public interface ProductRepository
        extends JpaRepository<Product,Long> {


}
