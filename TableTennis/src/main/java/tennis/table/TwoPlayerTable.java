package tennis.table;

import org.apache.log4j.Logger;
import tennis.players.Player;
import tennis.rules.Tie1010Rule;
import tennis.rules.Tie2020Rule;
import tennis.rules.TwoPlayerDefaultRule;
import tennis.rules.WinningRule;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TwoPlayerTable implements Table {

    private static final Logger LOGGER = Logger.getLogger("main");

    private List<Player> players;
    private WinningRule currentRule;
    private int currentRuleIdx = -1;
    private int server = 0;
    private List<WinningRule> tieRules;

    public TwoPlayerTable(Player one, Player two) {
        if(Objects.isNull(one) || Objects.isNull(two))
            throw new RuntimeException("Two Players required to start...");

        this.players = Arrays.asList(one, two);
        this.currentRule = new TwoPlayerDefaultRule("FIRST_TO_SCORE_11_RULE", one, two).applyRule(one,two);
        this.tieRules = Arrays.asList(new Tie1010Rule("TIE_10_10_RULE", one, two), new Tie2020Rule("TIE_20_20_RULE", one, two));
    }

    @Override
    public void start() {
        int serverRound = 0;
        while (true) {

            showScore();

            isTie();
            if (!Objects.isNull(winner())){
                showWinner();
                break;
            }

            serve(players.get(server));
            serverRound++;

            if(serverRound == currentRule.serveAllowed()){
                //change opponent
                server = server ^ 1;
                serverRound = 0;
            }
        }
    }

    private void showScore(){
        LOGGER.info("-----------SCORE---------------");
        players.stream().forEach(p -> LOGGER.info(p.toString()));
        LOGGER.info("-------------------------------");
    }
    private void showWinner(){
        LOGGER.info("-----------WINNER--------------");
        LOGGER.info(Objects.isNull(winner()) ? "" : winner().toString());
        LOGGER.info("-------------------------------");
    }

    private void isTie(){
        for(int next = currentRuleIdx + 1; next < tieRules.size(); next++){
            WinningRule rule = tieRules.get(next).applyRule(players.get(server), players.get(server ^ 1));
            if(rule != null){
                currentRule = rule;
                currentRuleIdx = next;
                break;
            }
        }
    }

    private void updateScore(int point) {
        if (hasWon(point)) {
            LOGGER.info(players.get(server).getId() + " has won...");
            players.get(server).setScore(players.get(server).getScore() + 1);
        } else {
            LOGGER.info(players.get(server).getId() + " has lost...");
            players.get(server ^ 1).setScore(players.get(server ^ 1).getScore() + 1);
        }
    }

    private boolean hasWon(int point) {
        return point == 1 ? true : false;
    }

    @Override
    public int serve(Player player) {
        int point = player.play() % 2 == 0 ? 1 : 0;
        updateScore(point);
        return point;
    }

    @Override
    public Player winner() {
        return currentRule.winner();
    }

    @Override
    public String WinningRule() {
        return currentRule != null ? currentRule.getId() : null;
    }
}
