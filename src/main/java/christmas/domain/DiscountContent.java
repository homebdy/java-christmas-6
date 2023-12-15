package christmas.domain;

public enum DiscountContent {

    D_DAY("크리스마스 디데이 할인: -%,d원"),
    WEEKDAY("평일 할인: -%,d원"),
    WEEKEND("주말 할인: -%,d원"),
    GIFT("증정 이벤트: -%,d원"),
    SPECIAL("특별 할인: -%,d원");

    private final String message;

    DiscountContent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
