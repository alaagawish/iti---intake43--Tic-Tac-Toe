
package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    
    private Player xPlayer;
    private Player oPlayer;
    private List<Move> movesList ;
    
    public GameModel() {
    }

    public GameModel(Player xPlayer, Player oPlayer, ArrayList<Move> movesList) {
        this.xPlayer = xPlayer;
        this.oPlayer = oPlayer;
        this.movesList = movesList;
    }
    
    

    public Player getxPlayer() {
        return xPlayer;
    }

    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }

    public Player getoPlayer() {
        return oPlayer;
    }

    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    public List<Move> getMovesList() {
        return movesList;
    }

    public void setMovesList(List<Move> movesList) {
        this.movesList = movesList;
    }

    @Override
    public String toString() {
        
        return xPlayer.getUsername()+"-"+oPlayer.getUsername(); 
    }
 
}
