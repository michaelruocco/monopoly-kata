package uk.co.mruoc.monopoly.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultLocation implements Location {

    @Getter
    private final String name;

}
