package productservice.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import productservice.dto.ProductDto;
import productservice.models.Category;
import productservice.models.Product;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product,Long> {

//    @Query(value = "select Product from Product left join Category " +
//            "on Product.category = :category",nativeQuery = true )
    List<Product> findProductByCategory(Category category);

}
