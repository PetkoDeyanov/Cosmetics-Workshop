package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;

public class ShampooImpl extends ProductImpl implements Shampoo {

    public static final int MIN_MILS = 0;
    private int milliliters;
    
    private UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType genderType, int milliliters, UsageType usageType) {
        super(name, brand, price, genderType);
        setMilliliters(milliliters);
        setUsageType(usageType);
    }

    private void setMilliliters(int mils){
        if(mils <= MIN_MILS) throw new IllegalArgumentException(ParsingHelpers.INVALID_MILLILITRES);
        this.milliliters = mils;
    }

    private void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    @Override
    public int getMillilitres() {
        return this.milliliters;
    }

    @Override
    public UsageType getUsageType() {
        return usageType;
    }

    // This method should be uncommented when you are done with the class.

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.print());
        sb.append(String.format(" #Milliliters: {%o}\n", getMillilitres()));
        sb.append(String.format(" #Usage: {%s}\n", getUsageType().toString()));
        sb.append(" ###").append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShampooImpl shampoo = (ShampooImpl) o;
        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }
}
