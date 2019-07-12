package bowling.model.frame.state;

import bowling.model.Pins;
import bowling.model.frame.State;

public abstract class FirstState implements State {

    private final Pins firstBowl;

    FirstState(Pins firstBowl) {
        this.firstBowl = firstBowl;
    }

    static State of(Pins pins) {
        if (Gutter.isMatch(pins)) {
            return Gutter.getInstance();
        }
        if (Strike.isMatch(pins)) {
            return Strike.getInstance();
        }
        return Hit.valueOf(pins);
    }

    @Override
    public State bowl(Pins secondBowl) {
        return SecondState.of(firstBowl, secondBowl);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    Pins getFirstBowl() {
        return firstBowl;
    }
}