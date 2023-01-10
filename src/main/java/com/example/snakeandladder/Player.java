package com.example.snakeandladder;
import  javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

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
