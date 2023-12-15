package christmas.view;

import christmas.constant.OutputMessage;
import christmas.domain.Events;
import christmas.domain.Order;

public class OutputView {

    public void printStartService() {
        System.out.println(OutputMessage.START_PLANNER.getMessage());
    }

    public void printDate() {
        System.out.println(OutputMessage.READ_DATE.getMessage());
    }

    public void printOrderMessage() {
        System.out.println(OutputMessage.READ_ORDER.getMessage());
    }

    public void printPreview() {
        System.out.println(OutputMessage.PREVIEW.getMessage());
    }

    public void printOrderList(Order order) {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        System.out.println(order.getOrderList());
    }

    public void printTotalBeforeDiscount(Order order) {
        System.out.println(OutputMessage.BEFORE_DISCOUNT.getMessage());
        System.out.println(order.getPriceBeforeDiscount());
    }

    public void printGift(Events events) {
        System.out.println(OutputMessage.GIFT_MESSAGE.getMessage());
        System.out.println(events.getGiftMenu());
    }

    public void printDiscount(Events events) {
        System.out.println(OutputMessage.DISCOUNT_MESSAGE.getMessage());
        System.out.println(events.getDiscountHistory());
    }

    public void printTotalDiscountPrice(Events events) {
        System.out.println(OutputMessage.TOTAL_DISCOUNT.getMessage());
        System.out.println(events.getDiscount());
    }

    public void printPriceAfterDiscount(Events events) {
        System.out.println(OutputMessage.AFTER_DISCOUNT.getMessage());
        System.out.println(events.getAfterDiscount());
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}