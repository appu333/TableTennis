package tennis;

import org.apache.log4j.Logger;
import tennis.players.Player;
import tennis.players.PlayerOne;
import tennis.players.PlayerTwo;
import tennis.table.Table;
import tennis.table.TwoPlayerTable;


public class Main {

    private static final Logger LOGGER = Logger.getLogger("main");

    public static void main(String... args){
        Player one = new PlayerOne("Player 1");
        Player two = new PlayerTwo("Player 2");
        Table tennis = new TwoPlayerTable(one, two);
        tennis.start();
        LOGGER.info("* " + tennis.winner().getId() + " has won the match with score " + tennis.winner().getScore() + " using game format " + tennis.WinningRule());
    }

}
