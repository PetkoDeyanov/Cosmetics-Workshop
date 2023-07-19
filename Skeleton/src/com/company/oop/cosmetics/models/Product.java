package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public abstract class Product implements com.company.oop.cosmetics.models.contracts.Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;
    public static final int MIN_PRICE = 0;
    public static final String PRICE_SHOULD_BE_NON_NEGATIVE = "Price should be non negative";


    private String name;
    private String brand;
    private double price;

    private GenderType genderType;

    public Product() {

    }

    public Product(String name, String brand, double price, GenderType genderType) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGenderType(genderType);
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Name");
        this.name = name;
    }

    public void setBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH, "Brand");
        this.brand = brand;
    }

    private void setPrice(double price) {
        if (price < MIN_PRICE) throw new IllegalArgumentException(PRICE_SHOULD_BE_NON_NEGATIVE);
        this.price = price;
    }

    public void setGenderType(GenderType genderType) {

        this.genderType = genderType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBrandName() {
        return this.brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGenderType() {
        return genderType;
    }

    @Override
    public String print() {
        return new String();
    }
}
