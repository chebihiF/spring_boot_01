package org.test.tp01.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            products = productService.getAllProducts();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @GetMapping("/lessthan/{qte}")
    public List<Product> getProductsLessThan(@PathVariable int qte) {
        List<Product> products = new ArrayList<>();
        try {
            products = productService.getProductLessThan(qte);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
