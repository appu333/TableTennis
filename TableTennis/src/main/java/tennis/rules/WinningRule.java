package tennis.rules;

import tennis.players.Player;

public abstract class WinningRule {

    protected String id;
    protected Player server;
    protected Player receiver;

    public WinningRule(String id, Player server, Player receiver) {
        this.id = id;
        this.server = server;
        this.receiver = receiver;
    }

    public abstract WinningRule applyRule(Player server, Player receiver);

    public abstract Player winner();

    public abstract int serveAllowed();

    public String getId() {
        return id;
    }
}
