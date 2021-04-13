package uk.co.mruoc.monopoly.players;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class RandomOrderPlayers extends Players {

    public RandomOrderPlayers(String... names) {
        this(toPlayers(Arrays.asList(names)));
    }

    public RandomOrderPlayers(Collection<Player> names) {
        super(randomize(names));
    }

    private static List<Player> randomize(Collection<Player> inputNames) {
        List<Player> randomizedNames = new ArrayList<>(inputNames);
        Collections.shuffle(randomizedNames);
        log.info("player order randomized as {}", randomizedNames);
        return Collections.unmodifiableList(randomizedNames);
    }

}
