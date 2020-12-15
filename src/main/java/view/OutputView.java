package view;

import domain.Menu;
import domain.Table;

import java.util.*;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDER_BOTTOM_LINE = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printOrderTable(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printOrderTable(List<Table> tables) {
        tables.forEach(table -> printBottomLine(table.hasOrdered()));
    }

    private static void printBottomLine(boolean isOrdered) {
        if (isOrdered) {
            System.out.println(BOTTOM_LINE);

            return;
        }

        System.out.println(ORDER_BOTTOM_LINE);
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMainScene() {
        System.out.println("## 메인화면");
        System.out.println("1. 주문등록");
        System.out.println("2. 결제하기");
        System.out.println("3. 프로그램 종료");
    }

    public static void printChoiceTable() {
        System.out.println("## 테이블을 선택하세요.");
    }

    public static void printReceipt(Map<Menu, Integer> orders) {
        System.out.println("## 주문내역");
        System.out.println("메뉴 수량 금액");
        printReceiptMenus(orders);
    }

    private static void printReceiptMenus(Map<Menu, Integer> orders) {
        Iterator<Map.Entry<Menu, Integer>> iterator = orders.entrySet().iterator();

        for (int i = 0; i <orders.size(); i++) {
            Map.Entry<Menu, Integer> entry = iterator.next();
            Menu key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key.getName() + " " + value + " " + key.getPrice() * value);
        }
    }
    
    public static void printTotalPayment(int value) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(value + "원");
    }
}
