package bowling.jaeyeonling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {
    @Test
    void t1() {
        Frame f = new NormalFrame();
        String v = f.visual();

        assertThat(v).isEqualTo("      |");
    }

    @Test
    void t2() {
        Frame f = new NormalFrame();
        f.bowl(0);
        String v = f.visual();

        assertThat(v).isEqualTo("  -   |");
    }

    @Test
    void t3() {
        Frame f = new NormalFrame();
        f.bowl(1);
        String v = f.visual();

        assertThat(v).isEqualTo(" 01   |");
    }

    @Test
    void t4() {
        Frame f = new NormalFrame();
        f.bowl(10);
        String v = f.visual();

        assertThat(v).isEqualTo("X     |");
    }

    @Test
    void t5() {
        Frame f = new NormalFrame();
        f.bowl(0);
        f.bowl(0);
        String v = f.visual();

        assertThat(v).isEqualTo("-|-   |");
    }

    @Test
    void t6() {
        Frame f = new NormalFrame();
        f.bowl(1);
        f.bowl(2);
        String v = f.visual();

        assertThat(v).isEqualTo("01|02 |");
    }

    @Test
    void t7() {
        Frame f = new NormalFrame();
        f.bowl(1);
        f.bowl(9);
        String v = f.visual();

        assertThat(v).isEqualTo("01|/  |");
    }

    @Test
    void t8() {
        Frame f = new FinalFrame();
        f.bowl(10);
        f.bowl(9);
        f.bowl(1);
        String v = f.visual();

        assertThat(v).isEqualTo("X|9|/");
    }
}
