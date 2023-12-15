package christmas.domain;

import java.util.Arrays;

public enum Special {

    THIRD(3),
    TEN(10),
    SEVENTEEN(17),
    TWENTY_FOUR(24),
    THIRTY_ONE(31),
    CHRISTMAS(25);

    private final int day;

    Special(int day) {
        this.day = day;
    }

    public static boolean isSpecialDay(int day) {
        return Arrays.stream(Special.values())
                .anyMatch(value -> value.day == day);
    }
}
