package com.company.oop.cosmetics.models;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (!containsProduct(product))
            throw new IllegalArgumentException(("Shopping cart does not contain product with name " + product.getName()) + "!");

        products.remove(product);
    }

    public boolean containsProduct(Product product) {

        if (products.contains(product)) return true;
        return false;
    }

    public double totalPrice() {

        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        //String result
        return totalPrice;
    }

}
