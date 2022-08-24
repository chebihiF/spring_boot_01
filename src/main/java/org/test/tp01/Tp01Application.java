package org.test.tp01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.test.tp01.product.ProductRepository;

@SpringBootApplication
public class Tp01Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp01Application.class, args);
    }

}
