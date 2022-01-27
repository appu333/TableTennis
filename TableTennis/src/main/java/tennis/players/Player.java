package tennis.players;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Player {

    private String id;
    private int score;
   private Queue<Integer> lastPoints = new LinkedList<>();

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

    public Queue<Integer> getLastPoints() {
        return lastPoints;
    }

    public void setLastPoints(int lastPoint) {
        this.lastPoints.add(lastPoint);
    }

    @Override
    public String toString() {
        return id + " | score : " + score;
    }
}
