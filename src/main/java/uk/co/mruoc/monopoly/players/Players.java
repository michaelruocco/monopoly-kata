package uk.co.mruoc.monopoly.players;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Players implements Iterable<String> {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;

    private final List<Player> values;

    private int nextPlayerIndex = 0;

    public static Collection<Player> toPlayers(Collection<String> names) {
        return names.stream().map(Player::new).collect(Collectors.toList());
    }

    public Players(String... values) {
        this(toPlayers(Arrays.asList(values)));
    }

    public Players(Collection<Player> values) {
        validate(values);
        log.info("players created with names {}", values);
        this.values = new ArrayList<>(values);
    }

    @Override
    public Iterator<String> iterator() {
        return streamNames().iterator();
    }

    public int size() {
        return values.size();
    }

    public Stream<String> streamNames() {
        return values.stream().map(Player::getName);
    }

    public String getNextPlayerName() {
        return values.get(nextPlayerIndex).getName();
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
        return values.get(nextPlayerIndex).hasName(name);
    }

    public boolean contains(String name) {
        return values.stream().anyMatch(player -> player.hasName(name));
    }

    private static void validate(Collection<Player> values) {
        if (values.size() < 2) {
            throw new LessThanMinPlayersException(values.size(), MIN_PLAYERS);
        }
        if (values.size() > 8) {
            throw new GreaterThanMaxPlayersException(values.size(), MAX_PLAYERS);
        }
    }

}
