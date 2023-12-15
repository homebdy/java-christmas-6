package christmas.view;

import christmas.constant.OutputMessage;
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

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}