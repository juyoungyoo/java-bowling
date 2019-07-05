package bowling.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerTest {

    @DisplayName("플레이어 이름을 생성하는데 성공한다")
    @Test
    void createPlayerName_success() {
        String name = "PJS";

        Player player = Player.of(name);

        assertThat(player).isEqualTo(Player.of(name));
    }

    @DisplayName("플레이어 이름이 3글자 초과할 시 생성에 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcf", "한글"})
    void createPlayerName_fail(String wrongName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Player.of(wrongName));
    }
}