package uk.co.mruoc.monopoly.board;


import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class DefaultLocations implements Locations {

    private final List<Location> values;

    public DefaultLocations() {
        this(buildValues());
    }

    @Override
    public Iterator<Location> iterator() {
        return values.iterator();
    }

    @Override
    public int getNumberOfLocations() {
        return values.size();
    }

    @Override
    public Location get(int index) {
        return values.get(index);
    }

    @Override
    public int get(String searchName) {
        return IntStream.range(0, values.size())
                .filter(i -> searchName.equals(values.get(i).getName()))
                .findFirst()
                .orElseThrow(() -> new LocationNotFoundException(searchName));
    }

    private static List<Location> buildValues() {
        Location chance = new DefaultLocation("Chance");
        Location communityChest = new DefaultLocation("Community Chest");
        return Arrays.asList(
                new Go(),
                new DefaultLocation("Old Kent Road"),
                new DefaultLocation("Community Chest"),
                new DefaultLocation("Whitechapel Road"),
                new DefaultLocation("Income Tax"),
                new DefaultLocation("Kings Cross Station"),
                new DefaultLocation("The Angel Islington"),
                chance,
                new DefaultLocation("Euston Road"),
                new DefaultLocation("Pentonville Road"),
                new DefaultLocation("Jail/Just Visiting"),
                new DefaultLocation("Pall Mall"),
                new DefaultLocation("Electric Company"),
                new DefaultLocation("Whitehall"),
                new DefaultLocation("Northumberland Avenue"),
                new DefaultLocation("Marylebone Station"),
                new DefaultLocation("Bow Street"),
                communityChest,
                new DefaultLocation("Marlborough Street"),
                new DefaultLocation("Vine Street"),
                new DefaultLocation("Free Parking"),
                new DefaultLocation("Strand"),
                chance,
                new DefaultLocation("Fleet Street"),
                new DefaultLocation("Trafalgar Square"),
                new DefaultLocation("Fenchurch Street Station"),
                new DefaultLocation("Leicester Square"),
                new DefaultLocation("Coventry Street"),
                new DefaultLocation("Water Works"),
                new DefaultLocation("Piccadilly"),
                new DefaultLocation("Go To Jail"),
                new DefaultLocation("Regent Street"),
                new DefaultLocation("Oxford Street"),
                communityChest,
                new DefaultLocation("Bond Street"),
                new DefaultLocation("Liverpool Street Station"),
                chance,
                new DefaultLocation("Park Lane"),
                new DefaultLocation("Super Tax"),
                new DefaultLocation("Mayfair")
        );
    }

}
