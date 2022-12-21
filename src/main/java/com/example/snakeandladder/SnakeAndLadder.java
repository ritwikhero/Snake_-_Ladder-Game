package com.example.snakeandladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeAndLadder extends Application {
    public static final int tilesize = 40, width = 10, height = 10;
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
        root.getChildren().add(boardImage);
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