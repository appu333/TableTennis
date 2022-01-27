package tennis;

import tennis.players.Player;
import tennis.players.PlayerOne;
import tennis.players.PlayerTwo;
import tennis.table.Table;
import tennis.table.TwoPlayerTable;

public class Test1515MatchTie {

    public static void main(String... args){
        Player one = new PlayerOne("Player 1");
        Player two = new PlayerTwo("Player 2");
        Table tennis = new TwoPlayerTable(one, two);
        tennis.start();
    }

    static class DummyPlayerOne extends PlayerOne {

        public DummyPlayerOne(String id) {
            super(id);
        }

        @Override
        public int play() {
            return 1;
        }
    }

    static class DummyPlayerTwo extends PlayerTwo {

        public DummyPlayerTwo(String id) {
            super(id);
        }

        @Override
        public int play() {
            return 2;
        }
    }

}
