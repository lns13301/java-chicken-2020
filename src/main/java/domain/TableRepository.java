package domain;

import java.util.*;

public class TableRepository {
    private static final int EMPTY_PRICE = 0;
    private static final int EMPTY_COUNT = 0;
    private static final int CHICKEN_DISCOUNT_UNIT = 10;
    private static final int CHICKEN_DISCOUNT = 10000;
    private static final float CASH_DISCOUNT = 0.95f;

    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void addOrder(int tableNumber, int menuNumber, int count) {
        findTableByTableNumber(tableNumber).addOrder(MenuRepository.findMenuByMenuNumber(menuNumber), count);
    }

    public static Table findTableByTableNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.isThisTable(tableNumber))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public static Map<Menu, Integer> orders(int tableNumber) {
        return findTableByTableNumber(tableNumber).getOrder();
    }

    public static int totalPaymentPrice(int tableNumber, boolean isCash) {
        Iterator<Map.Entry<Menu, Integer>> iterator = orders(tableNumber).entrySet().iterator();
        int totalPrice = EMPTY_PRICE;
        int totalChickenCount = EMPTY_COUNT;

        for (int i = 0; i < orders(tableNumber).size(); i++) {
            Map.Entry<Menu, Integer> entry = iterator.next();
            Menu key = entry.getKey();
            Integer value = entry.getValue();
            totalPrice += key.getPrice() * value;
            totalChickenCount += addChickenTotalCount(key, value);
        }

        totalPrice -= discountChicken(totalChickenCount);

        return discountCash(isCash, totalPrice);
    }

    private static int discountChicken(int value) {
        return value / CHICKEN_DISCOUNT_UNIT * CHICKEN_DISCOUNT;
    }

    private static int discountCash(boolean isCash, int price) {
        if (isCash) {
            return (int) Math.abs(price * CASH_DISCOUNT);
        }

        return price;
    }

    public static void resetTableOrders(int tableNumber) {
        findTableByTableNumber(tableNumber).initializeOrders();
    }

    public static int addChickenTotalCount(Menu menu, int count) {
        if (menu.isCategoryChicken()) {
            return count;
        }

        return EMPTY_COUNT;
    }
}
