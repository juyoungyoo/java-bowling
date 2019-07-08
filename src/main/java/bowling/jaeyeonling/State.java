package bowling.jaeyeonling;

public abstract class State {

    abstract boolean isFinished();
    abstract State bowl(int pins);
    abstract String visual();

    public static State ready() {
        return new Ready();
    }
}
