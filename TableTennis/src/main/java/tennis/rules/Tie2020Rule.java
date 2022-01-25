package tennis.rules;

import org.apache.log4j.Logger;
import tennis.players.Player;

public class Tie2020Rule extends WinningRule {

    private static final Logger LOGGER = Logger.getLogger("main");

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
