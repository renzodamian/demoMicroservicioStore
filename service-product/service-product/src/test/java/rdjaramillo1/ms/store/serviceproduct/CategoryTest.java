package rdjaramillo1.ms.store.serviceproduct;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import rdjaramillo1.ms.store.serviceproduct.entity.Category;
import rdjaramillo1.ms.store.serviceproduct.repository.CategoryRepository;
import rdjaramillo1.ms.store.serviceproduct.repository.ProductRepository;

@DataJpaTest
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Rollback(value = false)
    public void saveCategoryTest(){
        Category category = Category.builder()
                .name("Automovil")
                .build();
        categoryRepository.save(category);

        Assertions.assertThat(category.getId()).isGreaterThan(0);
    }

    
}
