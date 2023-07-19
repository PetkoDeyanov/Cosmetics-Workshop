package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;

public class ShampooImpl extends Product implements Shampoo {

    public static final int MIN_MILS = 0;
    public static final String MILLILITERS_SHOULD_BE_NON_NEGATIVE = "Milliliters should be non negative.";
    private int milliliters;
    
    private UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType genderType, int milliliters, UsageType usageType) {
        super(name, brand, price, genderType);
        setMilliters(milliliters);
        setUsageType(usageType);
    }

    private void setMilliters(int mils){
        if(mils <= MIN_MILS) throw new IllegalArgumentException(MILLILITERS_SHOULD_BE_NON_NEGATIVE);
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
