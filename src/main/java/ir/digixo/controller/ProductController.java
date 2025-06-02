package ir.digixo.controller;

import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{code}")
    public Product getDetails(@PathVariable String code) {
        return productService.getProduct(code);
    }

}

