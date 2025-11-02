package com.cincout.proyecto.product.service;

import com.cincout.proyecto.product.exceptions.InvalidProductException;
import com.cincout.proyecto.product.model.Product;

public class ProductValidator {

    public static void validate(Product product) throws InvalidProductException {
        if (product.getPrice() <= 0) {
            throw new InvalidProductException("El precio debe ser mayor que cero");
        }
        if (product.getStock() < 0) {
            throw new InvalidProductException("El estock no puedo ser cero");

        }
    }
}
