package tennis.players;

import java.util.Random;

public class PlayerTwo extends Player {

    private Random r = new Random();

    public PlayerTwo(String id) {
        super(id);
    }

    @Override
    public int play() {
        return r.nextInt(50-10) + 10;
    }
}
