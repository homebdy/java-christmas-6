package christmas.domain;

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
}
