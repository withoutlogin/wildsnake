package tech.allegro.wildsnake.application.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value="/api/v1/products", method= RequestMethod.GET)
    public Iterable<Product> getProducts()
    {
        return productRepository.findAll();
    }

}
