package com.example.snakeandladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeAndLadder extends Application {
    public static final int tilesize = 40, width = 10, height = 10;
    int lowerLine = tilesize*height;

    Player firstPlayer = new Player(tilesize, Color.BLACK, "Ritwik");
    Player secondPlayer = new Player(tilesize-10, Color.WHITE,"Rishik");
    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tilesize,height*tilesize+50);
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
        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(250);
        playerTwoButton.setTranslateY(lowerLine+20);


        root.getChildren().addAll(boardImage,playerOneButton,playerTwoButton,firstPlayer.getCoin(),secondPlayer.getCoin());
        return root;
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