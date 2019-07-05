package bowling.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerTest {

    @DisplayName("플레이어 이름을 생성하는데 성공한다")
    @Test
    void createPlayerName_success() {
        // given
        String name = "PJS";

        // when
        Player player = Player.of(name);

        // then
        assertThat(player).isEqualTo(Player.of(name));
    }

    @DisplayName("플레이어 이름이 3글자 초과할 시 생성에 실패한다")
    @Test
    void createPlayerName_fail() {
        // when
        String wrongName = "abcd";

        // exception
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Player.of(wrongName));
    }
}