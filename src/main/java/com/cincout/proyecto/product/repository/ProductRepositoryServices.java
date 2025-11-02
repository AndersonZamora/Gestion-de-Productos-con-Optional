package com.cincout.proyecto.product.repository;

import com.cincout.proyecto.product.exceptions.InvalidProductException;
import com.cincout.proyecto.product.exceptions.ProductNotFundException;
import com.cincout.proyecto.product.interfaces.ProductRepository;
import com.cincout.proyecto.product.model.Product;
import com.cincout.proyecto.product.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryServices implements ProductRepository {

    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() throws InvalidProductException {
        if (products.isEmpty()) {
            throw new InvalidProductException("La lista esta vacia");
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public void update(Optional<Product> product) throws ProductNotFundException {
        if (product.isPresent()) {
            Long idToUpdate = product.get().getId();
            int index = findIndexById(idToUpdate);
            if (index != -1) {
                products.set(index, product.get());
            } else {
                throw new ProductNotFundException("El producto no encotrado");
            }
        } else {
            throw new ProductNotFundException("El producto no encotrado");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return products.stream().anyMatch(p -> p.getId().equals(id));
    }

    @Override
    public List<Product> findByCategory(ProductCategory category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    private int findIndexById(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
