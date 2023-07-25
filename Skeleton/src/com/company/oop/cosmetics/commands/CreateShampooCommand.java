package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateShampooCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }


    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return createShampoo(parameters);
    }

    private String createShampoo(List<String> parameters) {

        String name = parameters.get(0);
       /* if (cosmeticsRepository.productExist(categoryName)) {
            throw new IllegalArgumentException(String.format(CATEGORY_ALREADY_EXISTS, categoryName));
        }*/
        String brand = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        int mils = ParsingHelpers.tryParseInt(parameters.get(4), ParsingHelpers.INVALID_MILLILITRES);
        UsageType usageType = ParsingHelpers.tryParseUsageType(parameters.get(5));

       cosmeticsRepository.createShampoo( name, brand,price , genderType, mils, usageType);

        return String.format(ParsingHelpers.PRODUCT_CREATED, "Shampoo", name);
    }

}
