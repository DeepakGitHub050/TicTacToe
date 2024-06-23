package Controller;

import Exceptions.*;
import WinningStrategies.WinningStrategy;
import models.Game;
import models.Player;

import java.util.List;

public class GameController {
    public Game startgame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws DuplicateSymbolException, PlayersCountMismatchException, MoreThanOneBotException{
        return Game.getbuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undo(Game game){
        game.undo();
    }
}
