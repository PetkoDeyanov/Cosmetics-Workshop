package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.Collections;
import java.util.List;

public class ToothpasteImpl extends ProductImpl implements Toothpaste {


    private final List<String> ingredients;
    public ToothpasteImpl(String name, String brandName, double price, GenderType genderType, List<String> ingredients) {
        super(name, brandName, price, genderType);
        this.ingredients = ingredients;

    }

    @Override
    public List<String> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.print());
        sb.append(String.format(" #Ingredients: {%s}", String.join(", ", getIngredients())));
        sb.append("\n ###").append(System.lineSeparator());
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToothpasteImpl toothpaste = (ToothpasteImpl) o;
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
}
