package christmas.domain;

import christmas.constant.OutputMessage;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Order {

    private static final String SPLIT_REGEX = "-";
    private static final int MENU_SEQUENCE = 0;
    private static final int NUMBER_SEQUENCE = 1;

    private final Map<Menu, Integer> elements;

    public Order(List<String> input) {
        this.elements = new EnumMap<>(Menu.class);
        addAllOrder(input);
    }

    private void addAllOrder(List<String> input) {
        input.forEach(value -> {
                    List<String> order = Arrays.stream(value.split(SPLIT_REGEX)).toList();
                    elements.put(Menu.getMenu(order.get(MENU_SEQUENCE)), Integer.valueOf(order.get(NUMBER_SEQUENCE)));
                });
    }

    private int getTotalPrice() {
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

    public String getPriceBeforeDiscount() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(OutputMessage.PRICE.getMessage(), getTotalPrice()));
        return stringBuilder.toString();
    }
}
