package tech.allegro.wildsnake.unit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;
import tech.allegro.wildsnake.showcase.model.ShowcaseItem;
import tech.allegro.wildsnake.showcase.service.ShowcaseService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ShowCaseServiceTest {

    @Mock
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    //Mockito Way
    @Test
    public void getShowCaseItemsShouldReturnItems() throws Exception {
        ShowcaseService showcaseService = new ShowcaseService(productRepository);

        List<Product> products = Arrays.asList(new Product("title1", "http://localhost/image1", "description1", BigDecimal.TEN), new Product("title2", "http://localhost/image2", "description2", BigDecimal.ONE));
        when(productRepository.findFirst3ByOrderByIdDesc()).thenReturn(products);

        List<ShowcaseItem> expectedItems = Arrays.asList(new ShowcaseItem("title1", "http://localhost/image1", BigDecimal.TEN), new ShowcaseItem("title2", "http://localhost/image2", BigDecimal.ONE));

        List<ShowcaseItem> result = showcaseService.getItems();
        assertThat(result.get(0).getTitle()).isEqualTo(expectedItems.get(0).getTitle());
        assertThat(result.get(0).getImageUrl()).isEqualTo(expectedItems.get(0).getImageUrl());
        assertThat(result.get(0).getPrice()).isEqualTo(expectedItems.get(0).getPrice());
        assertThat(result.get(1).getTitle()).isEqualTo(expectedItems.get(1).getTitle());
        assertThat(result.get(1).getImageUrl()).isEqualTo(expectedItems.get(1).getImageUrl());
        assertThat(result.get(1).getPrice()).isEqualTo(expectedItems.get(1).getPrice());
    }
}
