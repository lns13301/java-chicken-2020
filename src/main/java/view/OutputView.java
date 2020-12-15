package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
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

    public static void printChoiceFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void printChoiceTable() {
        System.out.println("## 테이블을 선택하세요.");
    }

    public static void printRegisterMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
    }
}
