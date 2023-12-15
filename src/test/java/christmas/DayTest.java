package christmas;

import christmas.domain.Day;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DayTest {

    @DisplayName("1~31사이의 숫자가 아닌 다른 숫자가 입력될 경우 예외 발생")
    @Test
    void biggerThanMaxSize() {
        int input = 0;
        assertThatThrownBy(() -> new Day(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("D-Day 전일 경우 true 반환")
    @Test
    void containForbidden() {
        int input = 5;
        Day day = new Day(input);

        boolean isBeforeDDay = day.isBeforeDday();

        assertThat(isBeforeDDay).isTrue();
    }
}
