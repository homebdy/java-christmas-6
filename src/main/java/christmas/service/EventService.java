package christmas.service;

import christmas.domain.Badge;
import christmas.domain.Day;
import christmas.domain.Events;
import christmas.domain.Order;

public class EventService {

    private final Order order;
    private final Events events;

    public EventService(Day day, Order order) {
        this.order = order;
        this.events = new Events(order, day);
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
