package christmas.constant;

public enum OutputMessage {

    START_PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    READ_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    READ_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ORDER_MENU("<주문 메뉴>"),
    NUMBER("개"),
    BLANK(" "),
    NEW_LINE("\n"),
    PREVIEW("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    PRICE("%,d원"),
    BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIFT_CONTENT("%s 1개"),
    NONE_DISCOUNT("없음"),
    GIFT_MESSAGE("<증정 메뉴>"),
    DISCOUNT_MESSAGE("<혜택 내역>"),
    TOTAL_DISCOUNT("<총혜택 금액>"),
    MINUS("-"),
    AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    BADGE("<12월 이벤트 배지>");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}