package uk.co.mruoc.monopoly.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationNotFoundExceptionTest {

    @Test
    void shouldReturnMessage() {
        String message = "error-message";

        Throwable error = new LocationNotFoundException(message);

        assertThat(error.getMessage()).isEqualTo(message);
    }

}