package com.cincout.proyecto.product.service;

import com.cincout.proyecto.product.exceptions.InvalidProductException;
import com.cincout.proyecto.product.exceptions.ProductNotFundException;
import com.cincout.proyecto.product.interfaces.ProductRepository;
import com.cincout.proyecto.product.model.Product;
import com.cincout.proyecto.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository _productRepository;

    public ProductService(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws InvalidProductException {
        return _productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return _productRepository.findById(id);
    }

    public void saveProduct(Product product) throws InvalidProductException {

        ProductValidator.validate(product);

        if (!_productRepository.existsById(product.getId())) {
            _productRepository.save(product);
            System.out.println("Producto guardado...");
        } else {
            throw new InvalidProductException("Producto ya registrado");
        }
    }

    public void deleteProduct(Long id) throws ProductNotFundException {

        Optional<Product> optionalProduct = _productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            _productRepository.delete(id);
            System.out.println("Producto eliminado");
        } else {
            throw new ProductNotFundException("Producto no encontrado");
        }
    }

    public void updateProduct(Product product) throws ProductNotFundException, InvalidProductException {

        ProductValidator.validate(product);

        Optional<Product> optionalProduct = _productRepository.findById(product.getId());

        if (optionalProduct.isPresent()) {
            _productRepository.update(optionalProduct);
            System.out.println("Producto actualizado");
        } else {
            throw new ProductNotFundException("Producto no encontrado");
        }
    }

    public List<Product> getAllProductsByCategory(ProductCategory category){
        return _productRepository.findByCategory(category);
    }
}
