package uk.co.mruoc.monopoly.players;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Players {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;

    private final Collection<String> names;

    public Players(String... names) {
        this(Arrays.asList(names));
    }

    public Players(Collection<String> names) {
        validate(names);
        log.info("players created with names {}", names);
        this.names = randomize(names);
        log.info("player order randomized as {}", this.names);
    }

    public boolean hasName(String name) {
        return names.contains(name);
    }

    public boolean hasFirstName(String name) {
        return names.stream().findFirst()
                .map(firstName -> firstName.equals(name))
                .orElse(false);
    }

    private static void validate(Collection<String> players) {
        if (players.size() < 2) {
            throw new LessThanMinPlayersException(players.size(), MIN_PLAYERS);
        }
        if (players.size() > 8) {
            throw new GreaterThanMaxPlayersException(players.size(), MAX_PLAYERS);
        }
    }

    private static Collection<String> randomize(Collection<String> inputNames) {
        List<String> randomizedNames = new ArrayList<>(inputNames);
        Collections.shuffle(randomizedNames);
        return Collections.unmodifiableList(randomizedNames);
    }
}
