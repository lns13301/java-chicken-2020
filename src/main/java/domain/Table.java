package domain;

public class Table {
    private final int number;
    private boolean isOrdered;

    public Table(final int number) {
        this.number = number;
        isOrdered = false;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
