package tech.allegro.wildsnake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import javax.annotation.PostConstruct;

@Configuration
@Profile("!prod")
public class DevDbConfig {

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void populateDatabase() {
        repository.save(new Product("1Snake", "", "", 12340l));
        repository.save(new Product("2Snake", "", "", 12340l));
        repository.save(new Product("3Snake", "", "", 1240l));
        repository.save(new Product("4Snake", "", "", 12540l));
        repository.save(new Product("5Snake", "", "", 240l));
        repository.save(new Product("6Snake", "", "", 52340l));
    }

}
