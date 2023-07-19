package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class CreateToothpasteCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private static final String TOOTHPASTE_CREATED = "Shampoo with name %s was created!";
    private static final String TOOTHPASTE_ALREADY_EXISTS = "Shampoo with name %s already exists!";
    private final CosmeticsRepository cosmeticsRepository;

    public CreateToothpasteCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return createToothpaste(parameters);
    }

    private String createToothpaste(List<String> parameters) {
        if (cosmeticsRepository.productExist(parameters.get(0))) {
            throw new IllegalArgumentException(String.format(TOOTHPASTE_ALREADY_EXISTS, parameters.get(0)));
        }
        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        List<String> ingredients = new ArrayList<>();
        for (int i = 3; i < parameters.size(); i++) {
            ingredients.add(parameters.get(i));
        }


        cosmeticsRepository.createToothpaste( name, brand,price , genderType, ingredients);

        return String.format(TOOTHPASTE_CREATED, name);
    }

    /*
public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return createShampoo(parameters);
    }

    private String createShampoo(List<String> parameters) {
        if (cosmeticsRepository.productExist(parameters.get(0))) {
            throw new IllegalArgumentException(String.format(SHAMPOO_ALREADY_EXISTS, parameters.get(0)));
        }

        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        int mils = Integer.parseInt(parameters.get(4));
        UsageType usageType = ParsingHelpers.tryParseUsageType(parameters.get(5));

       cosmeticsRepository.createShampoo( name, brand,price , genderType, mils, usageType);

        return String.format(SHAMPOO_CREATED, name);
    }
     */

}