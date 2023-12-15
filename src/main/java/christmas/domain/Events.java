package christmas.domain;


import org.mockito.internal.matchers.Or;

import java.util.EnumMap;
import java.util.Map;

public class Events {

    private static final int DEFAULT_D_DAY_PRICE = 1000;
    private static final int WEEKDAY_DISCOUNT = 2023;
    private final Map<DiscountContent, Integer> elements;

    public Events(Order order, Day day) {
        this.elements = new EnumMap<>(DiscountContent.class);
        getDdayDiscount(day);
        getWeekdayDiscount(order, day);
        getWeekendDiscount(order, day);
    }

    private void getDdayDiscount(Day day) {
        if (day.isBeforeDday()) {
            int discountPrice = DEFAULT_D_DAY_PRICE + 100 * (day.getDay() - 1);
            elements.put(DiscountContent.D_DAY, discountPrice);
        }
    }

    private void getWeekdayDiscount(Order order, Day day) {
        if (Week.isWeekday(day.getDay())) {
            addWeekdayDiscount(order);
        }
    }

    private void addWeekdayDiscount(Order order) {
        if (order.hasDessert()) {
            elements.put(DiscountContent.WEEKDAY, WEEKDAY_DISCOUNT * order.getDessertCount());
        }
    }

    private void getWeekendDiscount(Order order, Day day) {
        if (Week.isWeekend(day.getDay())) {
            addWeekendDiscount(order);
        }
    }

    private void addWeekendDiscount(Order order) {
        if (order.hasMainMenu()) {
            elements.put(DiscountContent.WEEKEND, WEEKDAY_DISCOUNT * order.getMainMenuCount());
        }
    }
}
