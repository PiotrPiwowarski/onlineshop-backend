package pl.piwowarski.onlineshopbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.onlineshopbackend.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
