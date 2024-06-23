package botPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotPlayingStrategy botPlayingStrategy) {
        return new EasyBotPlayingStrategy();
    }
}
