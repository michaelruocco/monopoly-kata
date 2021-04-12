package uk.co.mruoc.monopoly.round;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

@RequiredArgsConstructor
@Data
@Slf4j
public class Rounds {

    private static final int DEFAULT_NUMBER_OF_ROUNDS = 20;

    private final int numberOfRounds;
    private final Deque<Round> values = new LinkedBlockingDeque<>();

    public Rounds() {
        this(DEFAULT_NUMBER_OF_ROUNDS);
    }

    public boolean allHavePlayersInSameOrder() {
        return values.stream().findFirst()
                .filter(value -> values.stream().allMatch(round -> round.hasSamePlayerOrder(value)))
                .isPresent();
    }

    public long getNumberOfRoundsPlayed() {
        return values.size();
    }

    public long getNumberOfRoundsPlayedBy(String name) {
        return values.stream().filter(round -> round.containsPlayer(name)).count();
    }

    public Round startNextRound() {
        Round round = new Round(values.size() + 1);
        values.add(round);
        log.info("starting round {}", round.getNumber());
        return round;
    }

}
