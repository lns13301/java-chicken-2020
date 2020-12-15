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
        InputView.inputTableNumber();
        InputView.inputRegisterMenu();
        InputView.inputCount();
    }
}
