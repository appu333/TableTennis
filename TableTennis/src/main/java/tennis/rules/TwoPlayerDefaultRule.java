package tennis.rules;


import org.apache.log4j.Logger;
import tennis.players.Player;

public class TwoPlayerDefaultRule extends WinningRule {

    private static final Logger LOGGER = Logger.getLogger("main");

    public TwoPlayerDefaultRule(String id, Player server, Player receiver) {
        super(id, server, receiver);
    }

    @Override
    public WinningRule applyRule(Player server, Player receiver) {
        LOGGER.info("---------------------------------------");
        LOGGER.info("-----### Two Player Default Rule ###---");
        LOGGER.info("---------------------------------------");
        return this;
    }

    @Override
    public Player winner() {
        if(server.getScore() == 11)
            return server;
        if(receiver.getScore() == 11)
            return receiver;
        return null;
    }

    @Override
    public int serveAllowed() {
        return 2;
    }

}
