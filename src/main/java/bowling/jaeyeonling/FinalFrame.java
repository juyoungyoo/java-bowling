package bowling.jaeyeonling;

import java.util.Objects;

public class FinalFrame implements Frame {

    private Integer pins1;
    private Integer pins2;
    private Integer pins3;

    @Override
    public Frame bowl(int pins) {
        if (Objects.isNull(pins1)) {
            pins1 = pins;
            return this;
        }
        if (Objects.isNull(pins2)) {
            pins2 = pins;
            return this;
        }

        if (Objects.isNull(pins3)) {
            pins3 = pins;
            return this;
        }

        throw new IllegalStateException();
    }

    @Override
    public Frame next() {
        return this;
    }

    @Override
    public boolean isFinished() {
        return (Objects.nonNull(pins2) && pins1 + pins2 < 10) ||
                Objects.nonNull(pins3);
    }


    @Override
    public String visual() {
        String str = "";
        if (pins1 == 0) {
            str += "-";
        } else if (pins1 == 10) {
            str += "X";
        } else {
            str += pins1;
        }
        str += "|";
        if (pins2 == 0) {
            str += "-";
        } else if (pins1 + pins2 == 10) {
            str += "/";
        } else if (pins2 == 10) {
            str += "X";
        } else {
            str += pins2;
        }
        if (Objects.nonNull(pins3)) {
            str += "|";
            if (pins3 == 0) {
                str += "-";
            } else if (pins2 + pins3 == 10) {
                str += "/";
            } else if (pins3 == 10) {
                str += "X";
            } else {
                str += pins3;
            }
        }
        return str;
    }
}
