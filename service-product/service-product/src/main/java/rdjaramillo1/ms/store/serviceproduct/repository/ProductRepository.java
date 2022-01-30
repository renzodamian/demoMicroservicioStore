package rdjaramillo1.ms.store.serviceproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rdjaramillo1.ms.store.serviceproduct.entity.Category;
import rdjaramillo1.ms.store.serviceproduct.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory (Category category);
}
