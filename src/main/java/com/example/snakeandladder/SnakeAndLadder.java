package com.example.snakeandladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeAndLadder extends Application {
    public static final int tilesize = 40, width = 10, height = 10;
    int lowerLine = tilesize*height;
    int diceValue ;
    Label rollDiceValueLabel;

    boolean firstPlayerTurn = true, secondPlayerTurn = false, gameStarted = false;
    Button startGameButton;
    Player firstPlayer = new Player(tilesize, Color.BLACK, "Ritwik");
    Player secondPlayer = new Player(tilesize-10, Color.WHITE,"Rishik");
    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tilesize,height*tilesize+100);
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                Tile tile = new Tile(tilesize);
                tile.setTranslateX(j*tilesize);
                tile.setTranslateY(i*tilesize);
                root.getChildren().add(tile);
            }
        }
        Image img = new Image("C:\\Users\\ritwi\\IdeaProjects\\SnakeAndLadder\\SnakeAndLadder\\src\\main\\resources\\SnakeLadderBoard12Nov.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitHeight(height*tilesize);
        boardImage.setFitWidth(width*tilesize);

        Button playerOneButton =  new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(lowerLine+20);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(firstPlayerTurn){
                        setDiceValue();
                        firstPlayer.movePlayer(diceValue);
                        if(firstPlayer.playerWon() != null){
                            rollDiceValueLabel.setText(firstPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGameButton.setDisable(false);
                            startGameButton.setText("Start Game");

                        }
                        firstPlayerTurn = false;
                        secondPlayerTurn = true;
                    }
                }

            }
        });
        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(250);
        playerTwoButton.setTranslateY(lowerLine+20);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(secondPlayerTurn){
                        setDiceValue();
                        secondPlayer.movePlayer(diceValue);
                        if(secondPlayer.playerWon() != null){
                            rollDiceValueLabel.setText(secondPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                        }
                        secondPlayerTurn = false;
                        firstPlayerTurn = true;
                    }
                }


            }
        });
        startGameButton = new Button("Start");
        startGameButton.setTranslateX(130);
        startGameButton.setTranslateY(lowerLine+50);
        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted = true;
                startGameButton.setText("Game started");
                startGameButton.setDisable(true);
            }
        });

        rollDiceValueLabel = new Label("Start the Game");
        rollDiceValueLabel.setTranslateY(lowerLine+20);
        rollDiceValueLabel.setTranslateX(130);


        root.getChildren().addAll(boardImage,playerOneButton,playerTwoButton,firstPlayer.getCoin(),
                secondPlayer.getCoin(),rollDiceValueLabel,startGameButton);
        return root;
    }
    private void setDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        rollDiceValueLabel.setText("Dice Value : "+diceValue);
    }
    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("SnakeAndLadder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}