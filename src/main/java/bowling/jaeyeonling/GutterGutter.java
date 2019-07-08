package bowling.jaeyeonling;

public class GutterGutter extends Second {

    private static final Second INSTANCE = new GutterGutter();

    private GutterGutter() {
        super(0, 0);
    }

    public static Second getInstance() {
        return INSTANCE;
    }

    @Override
    String visual() {
        return "-|-   |";
    }
}
