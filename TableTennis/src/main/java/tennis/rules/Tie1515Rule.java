package tennis.rules;

import org.apache.log4j.Logger;
import tennis.players.Player;

import java.util.Iterator;

public class Tie1515Rule extends WinningRule {

    private static final Logger LOGGER = Logger.getLogger("main");

    public Tie1515Rule(String id, Player server, Player receiver) {
        super(id, server, receiver);
    }

    @Override
    public WinningRule applyRule(Player server, Player receiver) {
        if (server.getScore() == 15 && receiver.getScore() == 15) {
            LOGGER.info("-------------------------------");
            LOGGER.info("-----### 15:15 Tie ###---------");
            LOGGER.info("-------------------------------");
            return this;
        }
        return null;
    }

    @Override
    public Player winner() {
        if(compareLastTwo(server) != null)
            return server;
        if(compareLastTwo(receiver) != null)
            return receiver;

        return null;
    }

    private Player compareLastTwo(Player p){
        Iterator<Integer> itr = p.getLastPoints().iterator();
        if(itr.hasNext()){
            int last = itr.next();
            if(itr.hasNext())
                if(itr.next() == 1 && last == 1)
                    return p;

        }
        return null;
    }

    @Override
    public int serveAllowed() {
        return 2;
    }


}
