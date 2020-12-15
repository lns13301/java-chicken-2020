package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputChoiceFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputRegisterMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }


    public static int inputCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }
    
    public static int inputTable() {
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputPayment(int tableIndex) {
        System.out.println("## " + tableIndex + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }
}
