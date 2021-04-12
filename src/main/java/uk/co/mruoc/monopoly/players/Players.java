package uk.co.mruoc.monopoly.players;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

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
        this.names = new ArrayList<>(names);
    }

    @Override
    public Iterator<String> iterator() {
        return names.iterator();
    }

    public int size() {
        return names.size();
    }

    public Stream<String> stream() {
        return names.stream();
    }

    public String getNextPlayer() {
        return names.get(nextPlayerIndex);
    }

    public void updateNextPlayer() {
        nextPlayerIndex++;
        if (nextPlayerIndex >= size()) {
            nextPlayerIndex = 0;
        }
    }

    public boolean isFirstPlayerNext() {
        return nextPlayerIndex == 0;
    }

    public boolean isNext(String name) {
        return names.get(nextPlayerIndex).equals(name);
    }

    public boolean contains(String name) {
        return names.contains(name);
    }

    private static void validate(Collection<String> names) {
        if (names.size() < 2) {
            throw new LessThanMinPlayersException(names.size(), MIN_PLAYERS);
        }
        if (names.size() > 8) {
            throw new GreaterThanMaxPlayersException(names.size(), MAX_PLAYERS);
        }
    }

}
