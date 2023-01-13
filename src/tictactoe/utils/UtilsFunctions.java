package tictactoe.utils;

import java.io.File;
import tictactoe.constants.Constants;

public class UtilsFunctions {

    public static boolean checkGameDirectoryIsExist() {
        String gameDirectoryName = Constants.RECORDEDGAMEPATH;

        File gameDirectory = new File(gameDirectoryName);

        return gameDirectory.exists();
    }

    public static boolean checkPlayerDirectoryIsExist(String playerName) {
        if (!checkGameDirectoryIsExist()) {
            return false;
        }

        String playerDirectoryName = Constants.RECORDEDGAMEPATH.concat(playerName);
        File playerDirectory = new File(playerDirectoryName);

        return playerDirectory.exists();
    }

    public static String getPlayerDirectory(String playerName) {
        String playerDirectoryName = Constants.RECORDEDGAMEPATH.concat(playerName);
        return playerDirectoryName;
    }

}