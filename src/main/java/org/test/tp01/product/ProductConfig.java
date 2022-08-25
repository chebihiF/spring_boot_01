package org.test.tp01.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    private final ProductRepository productRepository;

    public ProductConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //@Bean
    CommandLineRunner init_product() {
        return args -> {
          productRepository.save(new Product("R001","Iphone13",1300,50));
          productRepository.save(new Product("R002","Sumsung Note 20",1500,100));
          productRepository.save(new Product("R003","TV Sony",13000,5));
          productRepository.save(new Product("R004","Iphone 12",700,100));
          productRepository.save(new Product("R005","PS5",400,500));

          productRepository.findProductByQteLessThan(100).forEach(System.out::println);
        };
    }
}
