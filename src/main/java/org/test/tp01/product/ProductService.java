package org.test.tp01.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() throws Exception {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductLessThan(int qte) throws Exception {
        if(qte < 0) throw new Exception("quantity must be > 0");
        return productRepository.findProductByQteLessThan(qte);
    }
}
