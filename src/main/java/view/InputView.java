package view;

import java.util.Scanner;

public class InputView {
    private static final String NEW_LINE = "\n";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println(NEW_LINE + "## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputChoiceFunction() {
        System.out.println(NEW_LINE + "## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputRegisterMenu() {
        System.out.println(NEW_LINE + "## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }


    public static int inputCount() {
        System.out.println(NEW_LINE + "## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }
    
    public static int inputTable() {
        System.out.println(NEW_LINE + "## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputPayment(int tableIndex) {
        System.out.println(NEW_LINE + "## " + tableIndex + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }
}
