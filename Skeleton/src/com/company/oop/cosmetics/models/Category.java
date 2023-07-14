package com.company.oop.cosmetics.models;

import java.util.ArrayList;

public class Category {
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 15;

    private String name;

    private ArrayList<Product> products = new ArrayList<>();


    public Category(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH)
            throw new IllegalArgumentException("Name should be between 2 and 15 symbols.");
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (products.contains(product))
            throw new IllegalArgumentException("Product is already added.");
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (!products.contains(product))
            throw new IllegalArgumentException("Product not found in category");
        products.remove(product);
    }

    public String print() {
        if (products.isEmpty()) {
            return ("#Category:" + this.name + "\n #No product in this category");
        }
        StringBuilder output = new StringBuilder();
        output.append("#Category: " + this.name);
        for (Product product : products) {
            output.append(" " + product.print());
        }
        return output.toString();

    }

}
