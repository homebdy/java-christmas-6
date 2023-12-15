package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int price;

    Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Badge getBadge(int price) {
        return Arrays.stream(Badge.values())
                .filter(value -> value.price <= price)
                .findFirst()
                .orElse(NONE);
    }
}
