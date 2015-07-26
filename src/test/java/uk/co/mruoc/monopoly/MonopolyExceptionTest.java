package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MonopolyExceptionTest {

    private static final String MESSAGE = "MESSAGE";

    private Exception exception;

    @Test
    public void shouldReturnMessage() {
        exception = new MonopolyException(MESSAGE);

        assertThat(exception.getMessage()).isEqualTo(MESSAGE);
    }

}
