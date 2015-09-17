package uk.co.mruoc.monopoly;

public class Rules {

    private final Game game;
    private final Board board;

    public Rules(Game game, Board board) {
        this.game = game;
        this.board = board;
    }

    public void apply(Player player) {
        Location location = game.getLocation(player);
        if (location.isGoToJail()) {
            player.setPosition(board.getJailPosition());
            return;
        }

        if (player.hasPassedGo())
            player.receiveSalary();
        if (location.isIncomeTax())
            player.payIncomeTax();
        if (location.isSuperTax())
            player.paySuperTax();
        if (player.canPurchase(location))
            player.purchase(location);
    }
}
