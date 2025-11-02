package com.cincout.proyecto;

import com.cincout.proyecto.product.controller.ProductController;
import com.cincout.proyecto.product.interfaces.ProductRepository;
import com.cincout.proyecto.product.repository.ProductRepositoryServices;
import com.cincout.proyecto.product.service.ProductService;
import com.cincout.proyecto.product.view.ProductView;

public class Main {
    public static void main(String[] args) {
        ProductRepository repositoryServices = new ProductRepositoryServices();
        ProductService productService = new ProductService(repositoryServices);
        ProductController controller = new ProductController(productService);
        ProductView view = new ProductView(controller);
        view.showMenu();
    }
}