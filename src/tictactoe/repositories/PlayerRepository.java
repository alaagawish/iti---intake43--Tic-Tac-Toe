package tictactoe.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.models.GameModel;
import tictactoe.utils.UtilsFunctions;

/**
 *
 * @author moazk
 */
public class PlayerRepository {
    
    public static String[] getRecordedGames(String playerName){
        String[] gamesNames = null;
        
        if(UtilsFunctions.checkPlayerDirectoryIsExist(playerName)){
            
            File file = new File(UtilsFunctions.getPlayerDirectory(playerName));
            gamesNames = file.list();
            
        }
        
        return gamesNames;
    }
    
    public static GameModel readGame(String playerName,String gameName){
        
        System.err.println(gameName);   
        File fileName = new File(UtilsFunctions.getPlayerDirectory(playerName)+"\\"+gameName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GameModel recordedGame = null;
        try {
            recordedGame = gson.fromJson(new FileReader(fileName.getAbsolutePath()),GameModel.class);
            
            System.err.println("Game: "+recordedGame);
            System.err.println("Move 0: "+recordedGame.getMovesList().get(0).getColumn());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlayerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return recordedGame;
    }
    
}
