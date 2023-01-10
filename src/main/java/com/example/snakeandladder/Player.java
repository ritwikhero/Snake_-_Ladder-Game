package com.example.snakeandladder;
import javafx.animation.TranslateTransition;
import  javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Player {
    private Circle coin;
    private String name;
    private int coinPosition;

    private static Board gameBoard = new Board();

    public Player(int tileSize, Color coinCoLor,String playerName){
        coinPosition = 1;
        coin = new Circle(tileSize/2);
        coin.setFill(coinCoLor);
        coin.setTranslateX(20);
        coin.setTranslateY(380);
    }
    public void movePlayer(int diceValue){
        if(coinPosition + diceValue <= 100){
            coinPosition += diceValue;
//            coin.setTranslateX(gameBoard.getXCoordinate(coinPosition));
//            coin.setTranslateY(gameBoard.getYCoordinate(coinPosition));
            translatePlayer();

            int newPosition = gameBoard.getNextPosition(coinPosition);
            if(newPosition != coinPosition){
                coinPosition = newPosition;
                translatePlayer();
            }
        }
    }

    public String playerWon(){
        if(coinPosition == 100){
            return name + " Won the game";
        }
        return null;
    }
    private void translatePlayer(){
        TranslateTransition move = new TranslateTransition(Duration.millis(1000),this.coin);
        move.setToX(gameBoard.getXCoordinate(coinPosition));
        move.setToY(gameBoard.getYCoordinate(coinPosition));
        move.setAutoReverse(false);
        move.play();
    }
    public void setCoin(Circle coin) {
        this.coin = coin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoinPosition(int coinPosition) {
        this.coinPosition = coinPosition;
    }

    public Circle getCoin() {
        return coin;
    }

    public String getName() {
        return name;
    }

    public int getCoinPosition() {
        return coinPosition;
    }
}
