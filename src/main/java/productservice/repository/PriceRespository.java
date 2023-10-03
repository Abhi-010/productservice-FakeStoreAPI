package productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productservice.models.Price;

import java.util.Optional;

public interface PriceRespository extends JpaRepository<Price,Long> {

    Optional<Price> findByPrice(double price);

}
