package christmas.domain;


import java.util.EnumMap;
import java.util.Map;

public class Events {

    private static final int DEFAULT_D_DAY_PRICE = 1000;
    private final Map<DiscountContent, Integer> elements;

    public Events(Order order, Day day) {
        this.elements = new EnumMap<>(DiscountContent.class);
        getDdayDiscount(day);
    }

    public void getDdayDiscount(Day day) {
        if (day.isBeforeDday()) {
            int discountPrice = DEFAULT_D_DAY_PRICE + 100 * (day.countDay() - 1);
            elements.put(DiscountContent.D_DAY, discountPrice);
        }
    }
}
