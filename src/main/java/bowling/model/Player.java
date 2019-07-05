package bowling.model;

import bowling.exception.NameLengthException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Player {

    public static final int MIN_LENGTH_OF_PLAYER_NAME = 3;

    private String name;

    private Player(String name) {
        this.name = name;
    }

    static Player of(String userName) {
        if (MIN_LENGTH_OF_PLAYER_NAME < userName.length()) {
            throw new NameLengthException(userName);
        }
        if (!Pattern.matches("^[a-zA-Z]*$", userName)) {
            throw new IllegalArgumentException();
        }
        return new Player(userName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player that = (Player) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
