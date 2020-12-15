package domain;

import java.util.*;

public class TableRepository {
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
}
