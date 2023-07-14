package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.Product;
import com.company.oop.cosmetics.models.ShoppingCart;

import java.util.ArrayList;
import java.util.Objects;

public class CosmeticsRepositoryImpl implements CosmeticsRepository {

    private final ArrayList<Product> products;
    private final ArrayList<Category> categories;
    private final ShoppingCart shoppingCart;

    public CosmeticsRepositoryImpl() {
        products = new ArrayList<>();
        categories = new ArrayList<>();

        shoppingCart = new ShoppingCart();
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public ArrayList<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findProductByName(String productName) {
        /**
         * Hint: You have to go through every product and see if one has name equal to productName.
         *       If not, "throw new IllegalArgumentException("Product with this name does not exist");"
         */
        Product out = null;
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                found = true;
                out = product;
            }
        }
        if (found) return out;
        else throw new IllegalArgumentException("Product with this name does not exist");
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        /**
         * Hint: You have to go through every category and see if one has name equal to categoryName.
         *       If not, "throw new IllegalArgumentException("Category with this name does not exist");"
         */
        Category find = new Category(categoryName);
        boolean found = false;
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                found = true;
                find = category;
            }
        }
        if (found) return find;
        else throw new IllegalArgumentException("Category with this name does not exist");

    }

    @Override
    public void createCategory(String categoryName) {
        Category category = new Category(categoryName);
        categories.add(category);
    }

    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        Product product = new Product(name, brand, price, gender);
        products.add(product);
    }

    @Override
    public boolean categoryExist(String categoryName) {
        /**
         * Hint: You have to go through every category and see if one has name equal to categoryName.
         *       If there is one, return true. If not, return false.
         */
        boolean out = false;
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                out = true;
                break;
            }
        }
        return out;

    }

    @Override
    public boolean productExist(String productName) {
        /**
         * Hint: You have to go through every product and see if one has name equal to productName.
         *       If there is one, return true. If not, return false.
         */
        boolean out = false;
        for (Product product : products) {
            if (product.getName().equals(productName))
                out = true;
        }
        return out;

    }
}
