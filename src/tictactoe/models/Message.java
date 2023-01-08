package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Message {

    String operation;
    String status;
    List<Player> players;

    public Message() {
        players = new ArrayList<Player>();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player players) {
        this.players.add(players);
    }

    @Override
    public String toString() {
        return "[operatio=" + operation + ", player[" + players + "]";
    }

}
