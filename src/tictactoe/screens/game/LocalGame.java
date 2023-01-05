package tictactoe.screens.game;

import tictactoe.models.Player;

public class LocalGame {

    public GameManager gameManager;
    Player playerOne, playerTwo;

    public LocalGame(Player playerOne, Player playerTwo, char board[][]) {

        gameManager = new GameManager(playerOne, playerTwo, board, Level.LOCAL);

    }

}
