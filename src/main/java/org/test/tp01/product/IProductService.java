package org.test.tp01.product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts() throws Exception;
    public List<Product> getProductLessThan(int qte) throws Exception;
}
