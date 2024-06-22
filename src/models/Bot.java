package models;

import models.Enums.BotDifficultyLevel;
import models.Enums.CellState;
import models.Enums.PlayerType;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(char symbol, String name, int id, PlayerType playerType, BotDifficultyLevel botDifficultyLevel){
        super(symbol,name,id,playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botPlayingStrategy);
    }

    @Override
    public Cell makeMove(Board board){
        System.out.println(" Get ready for the Bot move ");
        Cell cell = botPlayingStrategy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }
}
