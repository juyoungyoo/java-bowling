package bowling.jaeyeonling;

public abstract class Second extends State {

    protected final int pins1;
    protected final int pins2;

    protected Second(int pins1, int pins2) {
        this.pins1 = pins1;
        this.pins2 = pins2;
    }

    public static Second of(int pins1, int pins2) {
        if (pins1 + pins2 == 0) {
            return GutterGutter.getInstance();
        }
        if (pins1 + pins2 == 10) {
            return new Spare(pins1);
        }

        return new MissMiss(pins1, pins2);
    }

    @Override
    boolean isFinished() {
        return true;
    }

    @Override
    State bowl(int pins) {
        throw new IllegalStateException();
    }
}
