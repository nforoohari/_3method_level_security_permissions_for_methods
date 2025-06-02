package ir.digixo.repository;

import ir.digixo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProductRepository {

    private final Map<String, Product> products =
            Map.of("1", new Product("iphone", "bita"),
                    "2", new Product("ipad", "borna"),
                    "3", new Product("mac", "bardia"));

    public Product findProduct(String code) {
        return products.get(code);
    }
}
