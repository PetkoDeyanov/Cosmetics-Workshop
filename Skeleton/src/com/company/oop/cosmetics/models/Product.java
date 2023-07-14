package com.company.oop.cosmetics.models;

import javax.naming.Name;
import java.util.Objects;

public class Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_MIN_LENGTH = 2;
    public static final int BRAND_MAX_LENGTH = 10;

    private String name;
    private String brand;

    private double price;

    private GenderType gender;


    // "Each product in the system has name, brand, price and gender."

    public Product(String name, String brand, double price, GenderType gender) {
        setPrice(price);
        setBrand(brand);
        setGender(gender);
        setName(name);
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price should be non negative.");
    }

    public void setName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH)
            throw new IllegalArgumentException("Name should be between 3 and 10 symbols");
        this.name = name;
    }

    public void setBrand(String Brand) {
        if (Brand.length() < BRAND_MIN_LENGTH || Brand.length() > BRAND_MAX_LENGTH)
            throw new IllegalArgumentException("Brand name should be 2  and 10 symbols.");
        this.brand = Brand;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getBrand() {
        return this.brand;
    }

    public GenderType getGender() {

        return this.gender;
    }

    public String print() {
        //throw new UnsupportedOperationException("Not implemented yet.");
        // Format:
        //" #[Name] [Brand]
        // #Price: [Price]
        // #Gender: [Gender]
        // ==="
        StringBuilder result = new StringBuilder();
        result.append("#" + this.name + " " + this.brand + "\n");
        result.append("#Price: $" + this.price + "\n");
        result.append("#Gender: " + this.gender + "\n");
        result.append("===\n");
        return result.toString();

    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Product product = (Product) p;
        return Double.compare(this.getPrice(), product.getPrice()) == 0 &&
                Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getBrand(), product.getBrand()) &&
                this.getGender() == product.getGender();
    }

}
