package domain;

import view.InputView;
import view.OutputView;

public class PosManager {
    public void onPos() {
        State state = State.MAIN_SCENE;

        do {
            state = showMainScene(state);
            state = showTables(state);
            state = showPaymentScene(state);
        } while (!state.equals(State.QUIT));
    }

    public State showMainScene(State state) {
        OutputView.printMainScene();
        return getMainSceneState(state, InputView.inputChoiceFunction());
    }

    private State getMainSceneState(State state, int input) {
        if (input == 1) {
            return State.ORDER_SCENE;
        }

        if (input == 2) {
            return State.PAYMENT_SCENE;
        }

        if (input == 3) {
            return State.QUIT;
        }

        return state;
    }

    public State showTables(State state) {
        if (state.equals(State.ORDER_SCENE)) {
            OutputView.printTables(TableRepository.tables());

            int tableNumber = InputView.inputTableNumber();
            int menuNumber = InputView.inputRegisterMenu();
            int count = InputView.inputCount();

            TableRepository.addOrder(tableNumber, menuNumber, count);

            return state;
        }

        return state;
    }

    public State showPaymentScene(State state) {
        if (state.equals(State.PAYMENT_SCENE)) {

            OutputView.printTables(TableRepository.tables());

            int tableNumber = InputView.inputTable();

            OutputView.printReceipt(TableRepository.orders(tableNumber));
            boolean isCash = isCash(InputView.inputPayment(tableNumber));
            OutputView.printTotalPayment(TableRepository.totalPaymentPrice(tableNumber, isCash));

            return state;
        }

        return state;
    }

    private boolean isCash(int choice) {
        return choice == 2;
    }
}
