package bowling.model.frame;

import bowling.model.Pin;
import bowling.model.frame.state.AbstractStateTest;
import bowling.model.frame.state.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bowling.model.Pin.MAX;
import static bowling.model.Pin.MIN;
import static bowling.model.frame.state.Score.DEFAULT_SCORE;
import static bowling.model.frame.state.Score.ZERO_OF_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class FrameResultTest extends AbstractStateTest {

    @DisplayName("프레임이 끝나지 않았을 시 점수 계산하지 않는다(히트)")
    @Test
    void getState_hit() {
        // given
        Pin downPin = Pin.valueOf(MAX - 1);
        State state = ofHit(downPin);

        // when
        FrameResult frameResult = FrameResult.of(Score.parse(downPin), state);
        String expectedState = String.valueOf(downPin.count());

        // then
        assertThat(frameResult).extracting(FrameResult::getScore).isEqualTo(DEFAULT_SCORE);
        assertThat(frameResult).extracting(FrameResult::getState).isEqualTo(expectedState);
    }

    @DisplayName("프레임이 끝나지 않았을 시 점수 계산하지 않는다(거터)")
    @Test
    void getState_gutter() {
        // given
        Pin downPin = Pin.valueOf(MIN);
        State state = ofGutter();

        // when
        FrameResult frameResult = FrameResult.of(Score.parse(downPin), state);

        // then
        assertThat(frameResult).extracting(FrameResult::getScore).isEqualTo(DEFAULT_SCORE);
        assertThat(frameResult).extracting(FrameResult::getState).isEqualTo(state.printResult());
    }

    @DisplayName("계산이 끝났을 시 결과값을 반환하는데 성공한다")
    @Test
    void getScore_isFinishedAndCalculateComplete_success() {
        // given
        int totalScore = 14;
        Score score = scoreOf(ZERO_OF_COUNT, totalScore);
        State state = ofStrike();

        // when
        FrameResult frameResult = FrameResult.of(score, state);

        // then
        assertThat(frameResult).extracting(FrameResult::getScore).isEqualTo(totalScore);
    }

    @DisplayName("계산을 끝내지 못 했을 시 default 점수 반환")
    @Test
    void getScore_isFinishedAndCalculateComplete_success2() {
        // given
        Score score = scoreOf(ZERO_OF_COUNT + 1, 10);
        State state = ofStrike();

        // when
        FrameResult frameResult = FrameResult.of(score, state);

        // then
        assertThat(frameResult.getScore()).isEqualTo(DEFAULT_SCORE);
    }
}