package ir.digixo.repository;

import ir.digixo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProductRepository {

    private Map<String, Product> products =
            Map.of("1", new Product("iphone","mahsa"),
                    "2", new Product("ipad","ashkan"),
                    "3", new Product("mac","nader"));

    public Product findProduct(String code) {
        return products.get(code);

    }
}
