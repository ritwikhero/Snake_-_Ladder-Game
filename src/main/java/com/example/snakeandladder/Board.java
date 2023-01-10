package com.example.snakeandladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
   private ArrayList<Pair<Integer,Integer>> positionCoordinate;

   public Board(){
       populatePositionCoordinate();
   }


   private void populatePositionCoordinate(){
       positionCoordinate = new ArrayList<>();
       positionCoordinate.add(new Pair<Integer,Integer>(0,0));//dummy values at zero index
        int x =1, y = 10, xPos, yPos;
       for(int i = 0; i < SnakeAndLadder.width; i++){
           x = 1;
           for(int j = 0; j < SnakeAndLadder.height; j++){
               if(y%2 == 0){
                   xPos = x*SnakeAndLadder.tilesize-SnakeAndLadder.tilesize/2;
               }
               else{
                   xPos = SnakeAndLadder.width*SnakeAndLadder.tilesize - (x*SnakeAndLadder.tilesize-SnakeAndLadder.tilesize/2);
               }
              yPos = y*SnakeAndLadder.tilesize-SnakeAndLadder.tilesize/2;
              positionCoordinate.add(new Pair<Integer,Integer>(xPos,yPos));
              x++;
           }
           y--;
       }
   }
    public int getXCoordinate(int position){
       return  positionCoordinate.get(position).getKey();
    }
    public int getYCoordinate(int position){
        return  positionCoordinate.get(position).getValue();
    }

    public static void main(String[] args) {
//        Board board = new Board();
//        board.populatePositionCoordinate();
//        for(int i = 0 ; i < board.positionCoordinate.size(); i++){
//            System.out.println(i+" # x:"+ board.positionCoordinate.get(i).getKey()+" y:"+ board.positionCoordinate.get(i).getValue());
//        }
    }
}
