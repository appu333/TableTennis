package tennis.players;

import java.util.Random;

public class PlayerOne extends Player {

    private Random r = new Random();

    public PlayerOne(String id) {
        super(id);
    }

    @Override
    public int play() {
        return r.nextInt(50-10) + 10;
    }
}
