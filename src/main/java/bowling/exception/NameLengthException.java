package bowling.exception;

import static bowling.model.Player.MIN_LENGTH_OF_PLAYER_NAME;

public class NameLengthException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "플레이어 이름을 %d글자 이하로 입력해주세요. (입력값: %s)";

    public NameLengthException(String name) {
        super(String.format(ERROR_MESSAGE, MIN_LENGTH_OF_PLAYER_NAME, name));
    }
}
