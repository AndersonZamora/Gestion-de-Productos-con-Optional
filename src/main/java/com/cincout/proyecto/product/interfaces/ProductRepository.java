package com.cincout.proyecto.product.interfaces;

import com.cincout.proyecto.product.exceptions.InvalidProductException;
import com.cincout.proyecto.product.exceptions.ProductNotFundException;
import com.cincout.proyecto.product.model.Product;
import com.cincout.proyecto.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll() throws InvalidProductException;

    Optional<Product> findById(Long id);

    void save(Product product);

    void delete(Long id);

    void update(Optional<Product> product) throws ProductNotFundException;

    boolean existsById(Long id);

    List<Product> findByCategory(ProductCategory category);
}
