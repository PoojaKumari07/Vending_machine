package coin;

public enum Coin {
    ONE(1),
    TwO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    public final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
