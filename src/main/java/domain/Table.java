package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Table {
    private static final int ORDER_LIMIT = 99;

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

    public boolean addOrder(Menu menu, int count) {
        if (isOverOrderLimit(menu, count)) {
            return false;
        }

        orders.put(menu, count);
        return true;
    }

    private boolean isOverOrderLimit(Menu menu, int count) {
        if (orders.get(menu) == null) {
            return count > ORDER_LIMIT;
        }

        return orders.get(menu) + count > ORDER_LIMIT;
    }

    public boolean isThisTable(int number) {
        return this.number == number;
    }

    public Map<Menu, Integer> getOrder() {
        return Collections.unmodifiableMap(orders);
    }
}
