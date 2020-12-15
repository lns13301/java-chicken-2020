package domain;

import view.InputView;
import view.OutputView;

public class PosManager {
    public void showMainScene() {
        OutputView.printMainScene();
        InputView.inputChoiceFunction();
    }

    public void showTables() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        int menuNumber = InputView.inputRegisterMenu();
        int count = InputView.inputCount();

        TableRepository.addOrder(tableNumber, menuNumber, count);
    }
}
