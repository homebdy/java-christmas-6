package christmas.view;

import christmas.constant.OutputMessage;

public class OutputView {

    public void printStartService() {
        System.out.println(OutputMessage.START_PLANNER.getMessage());
    }

    public void printDate() {
        System.out.println(OutputMessage.READ_DATE.getMessage());
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}