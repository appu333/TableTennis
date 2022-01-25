package tennis.table;

import tennis.players.Player;
import tennis.rules.WinningRule;

public interface Table {

    void start();
    int serve(Player player);
    Player winner();
    String WinningRule();



}
