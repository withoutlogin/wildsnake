package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class ProductListFactory {
    private final ProductRepository repository;

    public ProductListFactory(ProductRepository repository) {
        this.repository = repository;
    }

    public void buildNumberOfProductsAndSave(int numberOfProducts) {
        IntStream.range(0, numberOfProducts).forEachOrdered(number -> {
            repository.save(new ProductBuilder(String.format("product %s", number)).whichPrice(BigDecimal.TEN).build());
        });
    }

}
