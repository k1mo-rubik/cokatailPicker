package ru.cocktails.common;

public interface Endpoints {
    interface Cocktail {
        String COCKTAIL_ADD = "/cocktail/add";
        String COCKTAIL_DELETE = "/cocktail/delete";

        String COCKTAIL_PICK = "/cocktail/pick";

    }
    interface Customer {
        String CUSTOMER_REGISTER = "/customer/register";
        String CUSTOMER_AUTHORIZATION = "/customer/authorization";
        String GET_CUSTOMER_HISTORY = "/customer/history";
    }
    interface Ingredient {
        String INGREDIENT = "/ingredient";
    }


}