package uk.co.mruoc.monopoly.round;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Data
public class Round {

    private final int number;
    private final Collection<String> players = new ArrayList<>();

    public void addPlayer(String player) {
        players.add(player);
    }

    public boolean containsPlayer(String player) {
        return players.contains(player);
    }

    public boolean hasSamePlayerOrder(Round otherRound) {
        return this.players.equals(otherRound.players);
    }

}
