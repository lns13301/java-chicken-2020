package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, Integer> orders;

    public Table(final int number) {
        this.number = number;
        orders = new HashMap<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean hasOrdered() {
        return !orders.isEmpty();
    }
}
