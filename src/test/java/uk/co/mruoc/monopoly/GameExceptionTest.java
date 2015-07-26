package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameExceptionTest {

    private static final String MESSAGE = "MESSAGE";

    private Exception exception;

    @Test
    public void shouldReturnMessage() {
        exception = new GameException(MESSAGE);

        assertThat(exception.getMessage()).isEqualTo(MESSAGE);
    }

}
