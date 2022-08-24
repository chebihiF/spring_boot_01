package org.test.tp01.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findProductByQteLessThan(@PathVariable(name = "qte") int qte);

    @Query("From Product where label = 'test' ")
    List<Product> testProduct() ;

}
