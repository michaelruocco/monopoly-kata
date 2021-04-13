package uk.co.mruoc.monopoly.board;

import lombok.RequiredArgsConstructor;
import uk.co.mruoc.monopoly.players.Player;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class Go implements Location {

    private final BigDecimal salary;

    public Go() {
        this(BigDecimal.valueOf(200));
    }

    @Override
    public String getName() {
        return "Go";
    }

    public void land(Player player) {
        player.receive(salary);
    }

}
