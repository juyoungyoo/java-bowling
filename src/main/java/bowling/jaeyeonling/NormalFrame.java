package bowling.jaeyeonling;

public class NormalFrame implements Frame {

    private State state = State.ready();

    static Frame ofFirst(){
        return new NormalFrame();
    }

    @Override
    public Frame bowl(int pins) {
        if(isFinished()){
            throw new IllegalStateException();
        }

        this.state = this.state.bowl(pins);
        return this;
    }

    @Override
    public Frame next() {
        if(isFinished()){
            return new NormalFrame();
        }
        return this;
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }

    public String visual() {
        return state.visual();
    }
}
