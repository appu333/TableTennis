package tennis.rules;

import tennis.players.Player;

import java.util.logging.Logger;

public class Tie2020Rule extends WinningRule {

    private static final Logger LOGGER = Logger.getGlobal();

    public Tie2020Rule(String id, Player server, Player receiver) {
        super(id, server, receiver);
    }

    @Override
    public WinningRule applyRule(Player server, Player receiver) {
        if (server.getScore() == 20 && receiver.getScore() == 20) {
            LOGGER.info("-------------------------------");
            LOGGER.info("-----### 20:20 Tie ###---------");
            LOGGER.info("-------------------------------");
            return this;
        }
        return null;
    }

    @Override
    public Player winner() {
        if (server.getScore() - receiver.getScore() == 1)
            return server;
        if (receiver.getScore() - server.getScore() == 1)
            return receiver;
        return null;
    }

    @Override
    public int serveAllowed() {
        return 2;
    }


}
