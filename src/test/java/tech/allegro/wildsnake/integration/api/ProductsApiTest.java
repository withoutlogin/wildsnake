package tech.allegro.wildsnake.integration.api;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.allegro.wildsnake.integration.WildSnakeIntegrationTest;
import tech.allegro.wildsnake.integration.builders.ProductListFactory;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;
import tech.allegro.wildsnake.showcase.model.ShowcaseItem;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductsApiTest extends WildSnakeIntegrationTest {

    @Test
    public void should_get_empty_list_of_products() {
        givenProduct()
                .buildNumberOfProductsAndSave(0);

        List<Product> products = thenGetProductsFromApi();

        assertThat(products).isEmpty();
    }

    @Test
    public void should_get_5_products() {
        givenProduct()
                .buildNumberOfProductsAndSave(5);

        List<Product> products = thenGetProductsFromApi();

        assertThat(products).hasSize(5);
    }

    @Test
    public void should_get_3_products() {
        givenProduct()
                .buildNumberOfProductsAndSave(3);

        List<Product> products = thenGetProductsFromApi();

        assertThat(products).hasSize(3);
    }

    @Before
    public void setup()
    {
        realProductRepository.deleteAll();
    }

    @Autowired
    ProductRepository realProductRepository;

    private ProductListFactory givenProduct() {
        return new ProductListFactory(realProductRepository);
    }

    private List<Product> thenGetProductsFromApi() {
        ResponseEntity<Product[]> forEntity = template.getForEntity("http://localhost:8080/api/v1/products", Product[].class);
        return Lists.newArrayList(forEntity.getBody());
    }

}
