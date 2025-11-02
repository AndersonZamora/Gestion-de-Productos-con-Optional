package com.cincout.proyecto.product.controller;

import com.cincout.proyecto.product.exceptions.InvalidProductException;
import com.cincout.proyecto.product.exceptions.ProductNotFundException;
import com.cincout.proyecto.product.model.Product;
import com.cincout.proyecto.product.model.ProductCategory;
import com.cincout.proyecto.product.service.ProductService;
import com.cincout.proyecto.product.utils.Validates;

import java.util.List;
import java.util.Optional;

public class ProductController {

    private final ProductService _productService;

    public ProductController(ProductService productService) {
        _productService = productService;
    }

    public void addProduct(Product product) throws InvalidProductException {
        Validates.ValidateObject(product, "Producto no valido");
        _productService.saveProduct(product);
    }

    public void removeProduct(Long id) throws ProductNotFundException, InvalidProductException {
        Validates.ValidateNumber(id, "Id no valido");
        _productService.deleteProduct(id);
    }

    public List<Product> getAllProduct() throws InvalidProductException {
        return _productService.getAllProducts();
    }

    public Optional<Product> getProductById(Long id) throws InvalidProductException {
        Validates.ValidateNumber(id, "Id no valido");
        return _productService.getProductById(id);
    }

    public void updateProduct(Product product) throws ProductNotFundException, InvalidProductException {
        Validates.ValidateObject(product, "Producto no valido");
        _productService.updateProduct(product);
    }

    public List<Product> getAllProductsByCategory(ProductCategory category) throws InvalidProductException {
        return _productService.getAllProductsByCategory(category);
    }
}
