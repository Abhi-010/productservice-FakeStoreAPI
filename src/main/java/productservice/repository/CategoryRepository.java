package productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productservice.models.Category;

public interface CategoryRepository
        extends JpaRepository<Category,Long> {

}
