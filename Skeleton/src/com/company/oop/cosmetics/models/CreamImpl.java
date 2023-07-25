package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;

public class CreamImpl extends ProductImpl implements Cream {

    private ScentType scent;
    public CreamImpl(String name, String brand, double price, GenderType genderType, ScentType scent) {
        super(name, brand, price, genderType);
        setScentType(scent);
    }

    private void setScentType(ScentType scentType) {
        this.scent = scentType;
    }


    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.print());
        sb.append(String.format(" #Scent: {%s}\n", getScent().toString()));
        sb.append("\n ###").append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public ScentType getScent() {
        return this.scent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreamImpl cream = (CreamImpl) o;
        return getName().equals(cream.getName()) &&
                getBrandName().equals(cream.getBrandName()) &&
                getPrice() == cream.getPrice() &&
                getGenderType().equals(cream.getGenderType()) &&
                getScent() == cream.getScent();
    }
}
