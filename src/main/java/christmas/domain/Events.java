package christmas.domain;

import christmas.constant.OutputMessage;

import java.util.EnumMap;
import java.util.Map;

public class Events {

    private static final int DEFAULT_DISCOUNT_PRICE = 0;
    private static final int DEFAULT_D_DAY_PRICE = 1000;
    private static final int WEEKDAY_DISCOUNT = 2023;
    private final Map<DiscountContent, Integer> elements;
    private final Order order;

    public Events(Order order, Day day) {
        this.elements = new EnumMap<>(DiscountContent.class);
        this.order = order;
        getDdayDiscount(day);
        getWeekdayDiscount(day);
        getWeekendDiscount(day);
        getSpecialDiscount(day);
        getGift();
    }

    private void getDdayDiscount(Day day) {
        if (day.isBeforeDday()) {
            int discountPrice = DEFAULT_D_DAY_PRICE + 100 * (day.getDay() - 1);
            elements.put(DiscountContent.D_DAY, discountPrice);
        }
    }

    private void getWeekdayDiscount(Day day) {
        if (Week.isWeekday(day.getDay())) {
            addWeekdayDiscount();
        }
    }

    private void addWeekdayDiscount() {
        if (order.hasDessert()) {
            elements.put(DiscountContent.WEEKDAY, WEEKDAY_DISCOUNT * order.getDessertCount());
        }
    }

    private void getWeekendDiscount(Day day) {
        if (Week.isWeekend(day.getDay())) {
            addWeekendDiscount();
        }
    }

    private void addWeekendDiscount() {
        if (order.hasMainMenu()) {
            elements.put(DiscountContent.WEEKEND, WEEKDAY_DISCOUNT * order.getMainMenuCount());
        }
    }

    private void getSpecialDiscount(Day day) {
        if (Special.isSpecialDay(day.getDay())) {
            elements.put(DiscountContent.SPECIAL, DEFAULT_D_DAY_PRICE);
        }
    }

    private void getGift() {
        if (order.isGift()) {
            elements.put(DiscountContent.GIFT, Menu.CHAMPAGNE.getPrice());
        }
    }

    public int getTotalDiscount() {
        if (!hasDiscount()) {
            return DEFAULT_DISCOUNT_PRICE;
        }
        return calculateDiscount();
    }

    private int calculateDiscount() {
        int price = DEFAULT_DISCOUNT_PRICE;
        for (DiscountContent content : elements.keySet()) {
            price += elements.get(content);
        }
        return price;
    }

    public int getAfterDiscountPrice() {
        if (hasGift()) {
            return order.getTotalPrice() - getTotalDiscount() + Menu.CHAMPAGNE.getPrice();
        }
        return order.getTotalPrice() - getTotalDiscount();
    }

    public boolean hasGift() {
        return elements.containsKey(DiscountContent.GIFT);
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

    public String getDiscount() {
        StringBuilder sb = new StringBuilder();
        if (hasDiscount()) {
            sb.append(OutputMessage.MINUS.getMessage());
        }
        sb.append(String.format(OutputMessage.PRICE.getMessage(), getTotalDiscount()));
        return sb.toString();
    }

    public String getAfterDiscount() {
        return String.format(OutputMessage.PRICE.getMessage(), getAfterDiscountPrice());
    }
}
