package ir.digixo.service;

import ir.digixo.entity.Product;
import ir.digixo.repository.ProductRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //@PostAuthorize("hasPermission(returnObject, 'ROLE_admin')")
    @PostAuthorize("hasPermission(returnObject, 'ROLE_admin')")
    public Product getProduct(String code) { return productRepository.findProduct(code);
    }
}
