package christmas.domain;

import christmas.constant.ExceptionMessage;

import java.util.Arrays;

public enum Menu {

    SOUP(Category.APPETIZER, "양송이 수프", 6000),
    TAPAS(Category.APPETIZER, "타파스", 5500),
    SALAD(Category.APPETIZER, "시저샐러드",8000),
    STEAK(Category.MAIN_MENU, "티본 스테이크", 55000),
    LIP(Category.MAIN_MENU, "바비큐립", 54000),
    SEAFOOD_PASTA(Category.MAIN_MENU, "해산물 파스타", 35000),
    CHRISTMAS_PASTA(Category.MAIN_MENU, "크리스마스 파스", 25000),
    CHOCOLATE_CAKE(Category.DESSERT, "초코케이크", 15000),
    ICE_CREAM(Category.DESSERT,"아이스크림", 5000),
    ZERO_COLA(Category.DRINKS, "제로콜라", 3000),
    WINE(Category.DRINKS, "레드와인", 60000),
    CHAMPAGNE(Category.DRINKS, "샴페인", 25000);

    private final Category category;
    private final String name;
    private final int price;

    Menu(Category category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public static Menu getMenu(String input) {
        return Arrays.stream(Menu.values())
                .filter(value -> value.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_MENU.getMessage()));
    }

    public String getName() {
        return name;
    }
}
