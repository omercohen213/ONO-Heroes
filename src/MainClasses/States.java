package MainClasses;

public enum States {
    HOMESTATE(0), CHOOSING_CHARACTER(1), GAMESTATE(2);

    private int value;

    States(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
