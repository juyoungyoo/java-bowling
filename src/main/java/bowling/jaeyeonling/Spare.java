package bowling.jaeyeonling;

public class Spare extends Second {

    public Spare(int pins1) {
        super(pins1, 10 - pins1);
    }

    @Override
    String visual() {
        return String.format("%02d|/  |", pins1);
    }
}
