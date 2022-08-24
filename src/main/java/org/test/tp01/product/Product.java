package org.test.tp01.product;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {
    @Id
    private String ref;
    private String label;
    private double price ;
    private int qte ;
}
