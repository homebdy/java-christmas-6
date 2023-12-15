package christmas.domain;

import christmas.constant.ExceptionMessage;

public class Day {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 31;
    private static final int D_DAY = 25;

    private final int value;

    public Day(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (!(START_RANGE <= value && value <= END_RANGE)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER.getMessage());
        }
    }

    public int getDay() {
        return value;
    }

    public boolean isBeforeDday() {
        return this.value <= D_DAY;
    }
}
