package uk.co.mruoc.monopoly.chance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ChanceCardsTest {

    private final ChanceCards chanceCards = new DefaultChanceCards();

    @Test
    public void shouldRepeatCardsInSameOrderWhenAllUsed() {
        List<ChanceCard> list1 = getAllCardsInDeck(chanceCards);
        List<ChanceCard> list2 = getAllCardsInDeck(chanceCards);
        assertThat(list1).isEqualTo(list2);
    }

    private List<ChanceCard> getAllCardsInDeck(ChanceCards chanceCards) {
        List<ChanceCard> cards = new ArrayList<>();
        for (int i = 0; i < chanceCards.size(); i++)
            cards.add(chanceCards.getNext());
        return cards;
    }

}
