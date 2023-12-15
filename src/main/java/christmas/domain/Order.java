package christmas.domain;

import christmas.constant.ExceptionMessage;
import christmas.constant.OutputMessage;

import java.util.*;

public class Order {

    private static final String SPLIT_REGEX = "-";
    private static final int MENU_SEQUENCE = 0;
    private static final int NUMBER_SEQUENCE = 1;
    private static final int STANDARD = 120000;
    private static final int DISCOUNT_START_PRICE = 10000;
    private static final int START_RANGE = 1;

    private final Map<Menu, Integer> elements;

    public Order(List<String> input) {
        this.elements = new EnumMap<>(Menu.class);
        validate(input);
        addAllOrder(input);
    }

    private void addAllOrder(List<String> input) {
        input.forEach(value -> {
                    List<String> order = Arrays.stream(value.split(SPLIT_REGEX)).toList();
                    elements.put(Menu.getMenu(order.get(MENU_SEQUENCE)), Integer.valueOf(order.get(NUMBER_SEQUENCE)));
                });
    }

    private void validate(List<String> input) {
        validateDuplicate(input);
        validateContainMenu(input);
        validateNumberRange(input);
    }

    private void validateDuplicate(List<String> input) {
        List<String> menus = new ArrayList<>();
        for (String menu : input) {
            String menuName = Arrays.stream(menu.split(SPLIT_REGEX)).toList().get(MENU_SEQUENCE);
            if (menus.contains(menuName)) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU.getMessage());
            }
            menus.add(menuName);
        }
    }

    private void validateContainMenu(List<String> input) {
        if (hasOnlyDrink(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU.getMessage());
        }
    }

    private boolean hasOnlyDrink(List<String> input) {
        int otherMenu = 0;
        for (String menu : input) {
            String menuName = Arrays.stream(menu.split(SPLIT_REGEX)).toList().get(MENU_SEQUENCE);
            if (Menu.getMenu(menuName).isDrink()) {
                continue;
            }
            otherMenu += 1;
        }
        return otherMenu == 0;
    }

    private void validateNumberRange(List<String> input) {
        for (String menu : input) {
            String number = Arrays.stream(menu.split(SPLIT_REGEX)).toList().get(NUMBER_SEQUENCE);
            if (Integer.parseInt(number) < START_RANGE) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU.getMessage());
            }
        }
    }

    public int getTotalPrice() {
        int price = 0;
        for (Menu key : elements.keySet()) {
            price += elements.get(key) * key.getPrice();
        }
        return price;
    }

    public int getDessertCount() {
        int count = 0;
        for (Menu key : elements.keySet()) {
            if (key.isDessert()) {
                count += elements.get(key);
            }
        }
        return count;
    }

    public boolean hasDessert() {
        return elements.keySet().stream()
                .anyMatch(Menu::isDessert);
    }

    public int getMainMenuCount() {
        int count = 0;
        for (Menu key : elements.keySet()) {
            if (key.isMainMenu()) {
                count += elements.get(key);
            }
        }
        return count;
    }

    public boolean hasMainMenu() {
        return elements.keySet().stream()
                .anyMatch(Menu::isMainMenu);
    }

    public boolean isGift() {
        return getTotalPrice() >= STANDARD;
    }

    public String getOrderList() {
        StringBuilder stringBuilder = new StringBuilder();
        elements.keySet()
                .forEach(key -> stringBuilder.append(key.getName())
                        .append(OutputMessage.BLANK.getMessage())
                        .append(elements.get(key))
                        .append(OutputMessage.NUMBER.getMessage())
                        .append(OutputMessage.NEW_LINE.getMessage()));
        return stringBuilder.toString();
    }

    public boolean isOverDiscountStandard() {
        return getTotalPrice() > DISCOUNT_START_PRICE;
    }

    public String getPriceBeforeDiscount() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(OutputMessage.PRICE.getMessage(), getTotalPrice()));
        return stringBuilder.toString();
    }
}
