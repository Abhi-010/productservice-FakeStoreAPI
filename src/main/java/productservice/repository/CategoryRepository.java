package productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productservice.models.Category;

import java.util.Optional;

public interface CategoryRepository
        extends JpaRepository<Category,Long> {

    Optional<Category> findDistinctByNameEquals(String name);

}
