package tennis.rules;

import tennis.players.Player;

import java.util.logging.Logger;

public class Tie1010Rule extends WinningRule {

    private static final Logger LOGGER = Logger.getGlobal();

    public Tie1010Rule(String id, Player server, Player receiver) {
        super(id, server, receiver);
    }

    @Override
    public WinningRule applyRule(Player server, Player receiver) {
        if(server.getScore() == 10 && receiver.getScore() == 10){
            LOGGER.info("-------------------------------");
            LOGGER.info("-----### 10:10 Tie ###---------");
            LOGGER.info("-------------------------------");
            return this;
        }
        return null;
    }

    @Override
    public Player winner() {
        if(server.getScore() - receiver.getScore() == 2)
            return server;
        if(receiver.getScore() - server.getScore() == 2)
            return receiver;
        return null;
    }

    @Override
    public int serveAllowed() {
        return 2;
    }


}
