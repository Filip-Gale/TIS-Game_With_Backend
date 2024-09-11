package hr.tis.academy.service.impl;

import hr.tis.academy.enums.GameState;
import hr.tis.academy.file.LogWriter;
import hr.tis.academy.model.GameBoard;
import hr.tis.academy.model.dto.GameHistoryDto;
import hr.tis.academy.model.dto.GameStateDto;
import hr.tis.academy.repository.GameBoardRepository;
import hr.tis.academy.service.GameBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameBoardImpl implements GameBoardService {

    private final GameBoardRepository gameBoardRepository;
    private static final String LOG_FILE = LogWriter.LOG_DIRECTORY + "/game_history.txt";
    private final LogWriter logWriter;

    @Autowired
    public GameBoardImpl(GameBoardRepository gameBoardRepository, LogWriter logWriter) {
        this.gameBoardRepository = gameBoardRepository;
        this.logWriter = logWriter;
    }

    @Override
    public List<GameHistoryDto> getGameBoardsForInterval(LocalDateTime start, LocalDateTime end) {
        List<GameBoard> gameBoards = gameBoardRepository.findGameBoardsInInterval(start, end);
        List<GameHistoryDto> gameHistoryDtoList = gameBoards.stream()
                .map(gameBoard -> {
                    String gameState = String.valueOf(gameBoard.getGameState());
                    long matchLength = Duration.between(gameBoard.getStartTime(), gameBoard.getEndTime()).toMinutes();
                    String matchLengthString = String.format("%d min", matchLength);
                    String userName = gameBoard.getDuckyUsers() != null ? gameBoard.getDuckyUsers().getUserName() : "Unknown";
                    return new GameHistoryDto(gameState, matchLengthString, userName);
                })
                .collect(Collectors.toList());

        String history = "";
        for(GameHistoryDto gameHistoryDto : gameHistoryDtoList) {
            history = "UserName: " + gameHistoryDto.userName() + ", " + "Match length: " + gameHistoryDto.matchLength() + ", " +
                    "Game State: " + gameHistoryDto.gameState();
        }
        logWriter.writeLogToFile(history, LOG_FILE);
        return gameHistoryDtoList;
    }

    @Override
    public void updateGameState(GameStateDto gameStateDto) {
        GameState newGameState = gameStateDtoToGameState(gameStateDto);
        GameBoard gameBoard = gameBoardRepository.findGameBoardByGameState(GameState.GAME_IN_PROGRESS);

        if(gameBoard != null) {
            gameBoard.setGameState(newGameState);
            gameBoardRepository.save(gameBoard);
        }
    }

    public GameState gameStateDtoToGameState(GameStateDto gameStateDto) {
        return GameState.valueOf(gameStateDto.getGameState().name());
    }
}
