package christmas.domain;

public class EventPlanner {

    private final Order order;
    private final Events events;

    public EventPlanner(Day day, Order order) {
        this.order = order;
        this.events = new Events(order, day);
        getDiscount();
    }

    public void getDiscount() {
        if (order.isOverDiscountStandard()) {
            events.startDiscount();
        }
    }

    public Order getOrder() {
        return order;
    }

    public Events getEvents() {
        return events;
    }

    public Badge getBadge() {
        return Badge.getBadge(events.getTotalDiscount());
    }
}
