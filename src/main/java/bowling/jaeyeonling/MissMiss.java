package bowling.jaeyeonling;

public class MissMiss extends Second {
    public MissMiss(int pins1, int pins2) {
        super(pins1, pins2);
    }

    @Override
    String visual() {
        return String.format("%02d|%02d |", pins1, pins2);
    }
}
