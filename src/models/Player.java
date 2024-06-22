package models;

import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

import models.Enums.CellState;
import models.Enums.PlayerType;

public class Player {
    private char symbol;
    private String name;
    private int id;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(char symbol, String name, int id, PlayerType playerType){
        this.symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        scanner = new Scanner(System.in);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Cell makeMove(Board board){
        System.out.println(this.name+" it's your turn to make a move, enter row and col");

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        while (!validateMove(row, col, board)){
            System.out.println(this.name+" Invalid move, pls try again");

            row = scanner.nextInt();
            col = scanner.nextInt();
        }

        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);

        return cell;
    }

    public boolean validateMove(int row, int col, Board board){
        if(row>=board.getDimension() || row<0)
            return false;
        if(col>=board.getDimension() || col<0)
            return false;
        if(!CellState.EMPTY.equals(board.getBoard().get(row).get(col).getCellState()))
            return false;
        return true;
    }
}
