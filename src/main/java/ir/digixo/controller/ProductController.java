package ir.digixo.controller;

import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{code}")
    public Product getDetails(@PathVariable String code) {
        return productService.getProduct(code);
    }
  /* @DeleteMapping("/products/{code}")
   public Product delete(@PathVariable String code) {
       return bookService.getBook(code);
   }*/
}

