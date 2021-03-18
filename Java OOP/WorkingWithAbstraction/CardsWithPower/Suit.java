package WorkingWithAbstraction.CardsWithPower;

public enum Suit {
    CLUBS (0),
    DIAMONDS (13),
    HEARTS (26),
    SPADES (39);

    private int valueSuit;

    Suit (int valueSuit){
        this.valueSuit = valueSuit;
    }

    public int getValue()
    {
        return this.valueSuit;
    }
}
