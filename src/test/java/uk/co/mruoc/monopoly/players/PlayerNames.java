package uk.co.mruoc.monopoly.players;

import java.util.stream.IntStream;

public class PlayerNames {

    public static String[] generate(int numberOfPlayers) {
        return IntStream.rangeClosed(1, numberOfPlayers)
                .mapToObj(i -> String.format("name-%d", i))
                .toArray(String[]::new);
    }

}
