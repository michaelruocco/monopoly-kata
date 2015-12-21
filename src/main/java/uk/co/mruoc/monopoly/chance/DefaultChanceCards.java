package uk.co.mruoc.monopoly.chance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultChanceCards implements ChanceCards {

    private final List<ChanceCard> cards = new ArrayList<>();
    private int index = 0;

    public DefaultChanceCards() {
        cards.add(new AdvanceToGo());
        cards.add(new AdvanceToMaryleboneStation());
        cards.add(new AdvanceToMayfair());
        cards.add(new AdvanceToPallMall());
        cards.add(new AdvanceToTrafalgarSquare());
        cards.add(new BankDividend());
        cards.add(new BuildingLoan());
        cards.add(new CrosswordCompetition());
        cards.add(new PaySchoolFees());
        cards.add(new SpeedingFine());
        Collections.shuffle(cards);
    }

    @Override
    public ChanceCard getNext() {
        ChanceCard card = cards.get(index);
        incrementIndex();
        return card;
    }

    @Override
    public int size() {
        return cards.size();
    }

    private void incrementIndex() {
        index++;
        if (index >= cards.size())
            index = 0;
    }

}
