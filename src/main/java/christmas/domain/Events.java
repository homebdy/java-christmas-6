package christmas.domain;

import christmas.constant.OutputMessage;

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
        getSpecialDiscount(day);
        getGift(order);
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

    private void getSpecialDiscount(Day day) {
        if (Special.isSpecialDay(day.getDay())) {
            elements.put(DiscountContent.SPECIAL, DEFAULT_D_DAY_PRICE);
        }
    }

    private void getGift(Order order) {
        if (order.isGift()) {
            elements.put(DiscountContent.GIFT, Menu.CHAMPAGNE.getPrice());
        }
    }

    public String getGiftMenu() {
        StringBuilder sb = new StringBuilder();
        if (elements.containsKey(DiscountContent.GIFT)) {
            sb.append(String.format(OutputMessage.GIFT_CONTENT.getMessage(), Menu.CHAMPAGNE.getName()));
            return sb.toString();
        }
        sb.append(OutputMessage.NONE_DISCOUNT.getMessage());
        return sb.toString();
    }

    public String getDiscountHistory() {
        StringBuilder sb = new StringBuilder();
        if (hasDiscount()) {
            getDiscount(sb);
            return sb.toString();
        }
        sb.append(OutputMessage.NONE_DISCOUNT.getMessage());
        return sb.toString();
    }

    private boolean hasDiscount() {
        return !elements.isEmpty();
    }

    private void getDiscount(StringBuilder sb) {
        for (DiscountContent content : elements.keySet()) {
            sb.append(String.format(content.getMessage(), elements.get(content)))
                    .append(OutputMessage.NEW_LINE.getMessage());
        }
    }
}
