package bowling.jaeyeonling;

public abstract class First extends State {

    protected final int pins;

    public First(int pins) {
        this.pins = pins;
    }

    public static First of(int pins) {
        if (pins == 0) {
            return new Gutter();
        }

        return new Miss(pins);
    }

    abstract String visual2();

    @Override
    String visual() {
        return visual2() + "|";
    }

    @Override
    boolean isFinished() {
        return false;
    }

    @Override
    State bowl(int pins) {
        return Second.of(this.pins, pins);
    }
}
