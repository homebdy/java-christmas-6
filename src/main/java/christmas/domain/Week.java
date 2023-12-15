package christmas.domain;

import christmas.constant.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public enum Week {
    MONDAY(List.of(4, 11, 18, 25)),
    TUESDAY(List.of(5, 12, 19, 26)),
    WEDNESDAY(List.of(6, 13, 20, 27)),
    THURSDAY(List.of(7, 14, 21, 28)),
    FRIDAY(List.of(1, 8, 15, 22, 29)),
    SATURDAY(List.of(2, 9, 16, 23, 30)),
    SUNDAY(List.of(3, 10, 17, 24, 31));

    private final List<Integer> days;

    Week(List<Integer> days) {
        this.days = days;
    }

    public static boolean isWeekday(int day) {
        Week week = Arrays.stream(Week.values())
                .filter(value -> value.days.contains(day))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_INTEGER.getMessage()));
        return week != SATURDAY && week != FRIDAY;
    }

    public static boolean isWeekend(int day) {
        Week week = Arrays.stream(Week.values())
                .filter(value -> value.days.contains(day))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_INTEGER.getMessage()));
        return week == SATURDAY || week == FRIDAY;
    }
}
