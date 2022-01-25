package tennis.players;

public abstract class Player {

    private String id;
    private int score;

    public Player(String id) {
        this.id = id;
    }

    abstract public int play();

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " | score : " + score;
    }
}
