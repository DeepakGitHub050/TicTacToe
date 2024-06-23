import Controller.GameController;
import Exceptions.*;
import WinningStrategies.ColWinningStrategy;
import WinningStrategies.DiagonalWinningStrategy;
import WinningStrategies.RowWinningStrategy;
import WinningStrategies.WinningStrategy;
import models.Bot;
import models.Enums.BotDifficultyLevel;
import models.Enums.GameState;
import models.Enums.PlayerType;
import models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Game;

public class Main {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountMismatchException, MoreThanOneBotException {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimension = 3;

        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();

        players.add(new Player('X', "Dks", 1, PlayerType.HUMAN));
        players.add(new Bot('O', "Bot", 2,PlayerType.BOT, BotDifficultyLevel.EASY));

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.startgame(dimension, players, winningStrategies);

        while(game.getGameState().equals(GameState.IN_PROG)){
            game.printBoard();

            System.out.println("Does anyone want to undo? (y/n)");

            String undo = scanner.next();

            if(undo.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        // If I'm here, it means game is not in progress anymore
        if(GameState.SUCCESS.equals(game.getGameState())){
            System.out.println(game.getWinner().getName()+", Congrats! You won the Game :)");
        }
        if(GameState.DRAW.equals(game.getGameState())){
            System.out.println("Match tied :| ");
        }
    }
}