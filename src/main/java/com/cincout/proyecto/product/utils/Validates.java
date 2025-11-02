package com.cincout.proyecto.product.utils;

import com.cincout.proyecto.product.exceptions.InvalidProductException;

public class Validates {

    public static <T extends Number> void ValidateNumber(T value, String message) throws InvalidProductException {
        if (value == null) {
            throw new InvalidProductException(message);
        }
    }

    public static <T> void ValidateObject(T obj, String message) throws InvalidProductException {
        if (obj == null) {
            throw new InvalidProductException(message);
        }
    }

    public static void validateText(String txt, String message) throws InvalidProductException {
        if (txt == null || txt.isEmpty()) {
            throw new InvalidProductException(message);
        }
    }
}
