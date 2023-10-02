package productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productservice.models.Price;

public interface PriceRepository
        extends JpaRepository<Price,Long> {

}
