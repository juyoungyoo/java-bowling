package bowling.jaeyeonling;

public interface Frame {

    Frame bowl(int pins);
    Frame next();
    boolean isFinished();
    String visual();
}
