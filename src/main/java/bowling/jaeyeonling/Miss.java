package bowling.jaeyeonling;

public class Miss extends First {

    public Miss(int pins) {
        super(pins);
    }

    @Override
    String visual2() {
        return String.format(" %02d   ", this.pins);
    }
}
