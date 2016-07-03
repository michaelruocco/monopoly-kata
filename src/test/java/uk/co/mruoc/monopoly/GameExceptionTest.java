package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameExceptionTest {

    private static final String MESSAGE = "MESSAGE";

    @Test
    public void shouldReturnMessage() {
        Exception exception = new GameException(MESSAGE);

        assertThat(exception.getMessage()).isEqualTo(MESSAGE);
    }

}
