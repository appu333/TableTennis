package tennis;

import tennis.players.Player;
import tennis.players.PlayerOne;
import tennis.players.PlayerTwo;
import tennis.table.Table;
import tennis.table.TwoPlayerTable;

public class TestOnePlayerMatch {

    public static void main(String... args){
        try {
            Player one = new DummyPlayerOne("Player 1");
            Table tennis = new TwoPlayerTable(one, null);
            tennis.start();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

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


}
