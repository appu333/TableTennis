package tennis;

import tennis.players.Player;
import tennis.players.PlayerOne;
import tennis.players.PlayerTwo;
import tennis.table.Table;
import tennis.table.TwoPlayerTable;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getGlobal();

    public static void main(String... args){
        Player one = new PlayerOne("Player 1");
        Player two = new PlayerTwo("Player 2");
        Table tennis = new TwoPlayerTable(one, two);
        tennis.start();
        LOGGER.info("* " + tennis.winner().getId() + " has won the match with score " + tennis.winner().getScore() + " using game format " + tennis.WinningRule());
    }

}
