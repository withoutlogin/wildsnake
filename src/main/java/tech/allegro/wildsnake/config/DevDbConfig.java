package tech.allegro.wildsnake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Configuration
@Profile("!prod")
public class DevDbConfig {

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void populateDatabase() {
        repository.save(new Product("1Snake", "", "", BigDecimal.TEN));
        repository.save(new Product("2Snake", "", "", BigDecimal.TEN));
        repository.save(new Product("3Snake", "", "", BigDecimal.TEN));
        repository.save(new Product("4Snake", "", "", BigDecimal.TEN));
        repository.save(new Product("5Snake", "", "", BigDecimal.TEN));
        repository.save(new Product("6Snake", "", "", BigDecimal.TEN));
    }

}
