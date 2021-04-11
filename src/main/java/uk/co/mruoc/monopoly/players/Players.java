package uk.co.mruoc.monopoly.players;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class Players implements Iterable<String> {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;

    private final List<String> names;

    private int nextPlayerIndex = 0;

    public Players(String... names) {
        this(Arrays.asList(names));
    }

    public Players(Collection<String> names) {
        validate(names);
        log.info("players created with names {}", names);
        this.names = randomize(names);
        log.info("player order randomized as {}", this.names);
    }

    @Override
    public Iterator<String> iterator() {
        return names.iterator();
    }

    public boolean isNext(String name) {
        return names.get(nextPlayerIndex).equals(name);
    }

    public boolean contains(String name) {
        return names.contains(name);
    }

    private static void validate(Collection<String> players) {
        if (players.size() < 2) {
            throw new LessThanMinPlayersException(players.size(), MIN_PLAYERS);
        }
        if (players.size() > 8) {
            throw new GreaterThanMaxPlayersException(players.size(), MAX_PLAYERS);
        }
    }

    private static List<String> randomize(Collection<String> inputNames) {
        List<String> randomizedNames = new ArrayList<>(inputNames);
        Collections.shuffle(randomizedNames);
        return Collections.unmodifiableList(randomizedNames);
    }

}
