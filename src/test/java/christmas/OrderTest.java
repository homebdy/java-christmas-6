package christmas;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OrderTest {

    @DisplayName("음료만 입력한 경우 예외 발생")
    @Test
    void onlyDrink() {
        List<String> input = List.of("레드와인-1");
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1이상의 숫자가 입력되지 않은 경우 예외 발생")
    @Test
    void smallNumber() {
        List<String> input = List.of("시저샐러드-0");
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 메뉴를 입력한 경우 예외 발생")
    @Test
    void duplicateInput() {
        List<String> input = List.of("시저샐러드-1", "시저샐러드-1");
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메인 메뉴 갯수 반환")
    @Test
    void countMainMenu() {
        List<String> input = List.of("티본스테이크-3", "시저샐러드-1");
        Order order = new Order(input);

        int count = order.getMainMenuCount();

        assertThat(count).isEqualTo(3);
    }

    @DisplayName("메인 메뉴가 존재할 경우 true 반환")
    @Test
    void hasMainMenu() {
        List<String> input = List.of("티본스테이크-1", "시저샐러드-1");
        Order order = new Order(input);

        boolean hasMainMenu = order.hasMainMenu();

        assertThat(hasMainMenu).isTrue();
    }
}
