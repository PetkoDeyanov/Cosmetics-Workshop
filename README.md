# OOP Workshop - Cosmetics Shop 1

## Preface

Before you start coding, read this document from top to bottom. It contains some valuable information that will make your work easier.

## Description

You are given a software system for managing a cosmetics shop. It allows users to create models (`Product`, `Category`). There is also a `Shopping cart`. Products can be added to or removed from a category and a shopping cart. Your task is to design an object-oriented class hierarchy to model the cosmetics shop, using the best practices for object-oriented design (OOD) and object-oriented programming (OOP). Encapsulate all fields correctly and use validation whenever needed.

## Architecture

The system already has a working `Engine` which executes a sequence of commands read from the console. It uses the classes and interfaces in your project (see the `CosmeticsEngine` class). You do not have to touch anything in it or the `main()` method, but you could try to understand how they work.

## Models

> Note: All validation intervals are inclusive (closed).
> Note: Put your classes in the **models** package.

### **Product**

- Each `product` in the system has a `name, brand, price, and gender`.
- `name` - the name's length should be between `3` and `10` symbols.
- Exception message: `Name should be between 3 and 10 symbols.`
- `brand` - the brand name's length should be between `2` and `10` symbols.
- Exception message: `Brand should be between 2 and 10 symbols.`
- `price` cannot be negative.
- Exception message: `Price should be non negative.`
- `Gender type` can be `[Men, Women or Unisex]`.
- Product's `print()` method should return text in the following format:

```none
 #{name} {brand}
 #Price: {price}
 #Gender: {genderType}
```

### **Category**

- Each `category` has a `name`. `Products` can be **added** to or **removed** from a `category`. 
- `name` - the category name's length should be between `2` and `15` symbols.
- Exception message: `Name should be between 2 and 15 symbols.`  
- Adding the same `product` to one `category` more than once is allowed.
- When removing a `product` from a `category`, you should throw an `exception` if the product is not found.
- Exception message: `Product not found in category`.

> Note: We have yet to talk about exceptions, but all you need to know for now is that they indicate if something goes wrong. If you write `throw new IllegalArgumentException()`, you are **throwing an exception** (research how to throw `IllegalArgumentException`).

- Category's `print()` method should return text in the following format:

```none
#Category: {category name}
 #{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 ===
 #{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 ===
```

```none
#Category: Shampoos
 #No product in this category
```

### **ShoppingCart**

- `Products` can be **added** to or **removed** from a `shopping cart`.
- Adding the same product more than once is allowed.
- When removing a `product` from the `shopping cart` throw an exception, if it is not in it.
- Exception message: `Shopping cart does not contain product with name %s!`.
- The `shopping cart` can calculate its products `total price`.

## Constraints

- Check the example below to understand the printing format better.
- Format all floating-point values with **two digits** after the decimal point. ([*hint*](https://www.google.com/search?q=java+format+two+decimal+places)).

> *Hint: Use exceptions for validation.*
> *Hint: Check out the `ValidationHelpers` class. It has some methods that might be useful.*

## Unit Tests

- You are given unit tests to keep track of your progress.
- Run them by right-clicking the **tests** package and selecting **Run 'All Tests'**.
- If you get stuck, check out the tests' names to guide you on what to do.

> *Hint: Run the tests whenever you finish a task to check if it's implemented correctly.*
 
> Note: Be careful not to change anything in the **tests** folder.

## Step by step guide

1. Start with the `Product` class

- Apply the Encapsulation principle to all the fields (make sure all fields are private, provide getters and setters for them).

2. Navigate to the `CosmeticsRepositoryImpl` class in the **cosmetics.core.factories** package

- Implement the `find()` methods - they should go through the respective collections and return the item that has the given name. What should happen if there is no item with that name? Maybe throw an exception?
- Exception message: `Product %s does not exist!` or `Category %s does not exist!`
- Implement the `create()` methods - they accept the needed arguments to create a `category` or a `product`.
- Implement the `exists()` methods - they go through the respective collections and return **true** if there is an item that has the given name.

3. Finish the `ShoppingCart` class

- Encapsulate it (don't allow direct access to it).
- Initialize the `products` collection.

```java
public ShoppingCart() {
        products = new ArrayList<Product>();
}
```

- Implement the methods that **add**, **remove** and **search for a** product from the collection.
- Implement the **total price** method.

4. Finish the `Category` class

- Initialize the collection.
- Implement the methods that **add**, **remove** and **get** products from the collection.

5. Implement `print()` methods in both the `Category` and `Product` classes.

- To test the `print()` method, you must run the application, pass the sample input and check the output.

### Sample Input

```
CreateProduct MyMan Nivea 10.99 Men
CreateCategory Shampoos
AddToCategory Shampoos MyMan
AddToShoppingCart MyMan
ShowCategory Shampoos
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
Exit
```

### Sample Output

```
Product with name MyMan was created!
Category with name Shampoos was created!
Product MyMan added to category Shampoos!
Product MyMan was added to the shopping cart!
#Category: Shampoos
 #MyMan Nivea
 #Price: $10.99
 #Gender: MEN
 ===
$10.99 total price currently in the shopping cart!
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
No product in shopping cart!
```
