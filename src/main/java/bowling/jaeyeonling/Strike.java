package bowling.jaeyeonling;

public class Strike extends State {

    @Override
    boolean isFinished() {
        return true;
    }

    @Override
    State bowl(int pins) {
        throw new IllegalStateException();
    }

    @Override
    String visual() {
        return "X     |";
    }
}

