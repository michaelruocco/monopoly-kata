package uk.co.mruoc.monopoly.players;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Player {

    private final String name;
    private BigDecimal balance;

    public Player(String name) {
        this(name, BigDecimal.ZERO);
    }

    public boolean hasName(String otherName) {
        return this.name.equals(otherName);
    }

    public void receive(BigDecimal amount) {
        balance = balance.add(amount);
    }

}
