package bowling.jaeyeonling;

public class Ready extends State {

    @Override
    boolean isFinished() {
        return false;
    }

    @Override
    State bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }

        return First.of(pins);
    }

    @Override
    String visual() {
        return "      |";
    }
}
