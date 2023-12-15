package christmas.domain;

public enum Category {

    APPETIZER,
    MAIN_MENU,
    DESSERT,
    DRINKS;

    public boolean isDrinks() {
        return this == DRINKS;
    }
}
