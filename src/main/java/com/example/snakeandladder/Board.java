package com.example.snakeandladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
   private ArrayList<Pair<Integer,Integer>> positionCoordinate;
   private ArrayList<Integer> snakeLadderPosition;

   public Board(){
       populatePositionCoordinate();
       populateSnakeLadderPosition();
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

   private void populateSnakeLadderPosition(){
       snakeLadderPosition = new ArrayList<>();
       for(int i = 0; i < 101; i++){
           snakeLadderPosition.add(i);
       }
       snakeLadderPosition.set(4,25);
       snakeLadderPosition.set(13,46);
       snakeLadderPosition.set(27,5);
       snakeLadderPosition.set(33,49);
       snakeLadderPosition.set(40,3);
       snakeLadderPosition.set(42,63);
       snakeLadderPosition.set(43,18);
       snakeLadderPosition.set(50,69);
       snakeLadderPosition.set(54,31);
       snakeLadderPosition.set(62,81);
       snakeLadderPosition.set(66,45);
       snakeLadderPosition.set(74,92);
       snakeLadderPosition.set(76,45);
       snakeLadderPosition.set(89,53);
       snakeLadderPosition.set(99,41);
   }
        public int getXCoordinate(int position){
       return  positionCoordinate.get(position).getKey();
    }
    public int getYCoordinate(int position){
        return  positionCoordinate.get(position).getValue();
    }

    public int getNextPosition(int position){
       if(position >= 1 && position <= 100)
        return snakeLadderPosition.get(position);
       else return -1;
    }
    public static void main(String[] args) {
//        Board board = new Board();
//        board.populatePositionCoordinate();
//        for(int i = 0 ; i < board.positionCoordinate.size(); i++){
//            System.out.println(i+" # x:"+ board.positionCoordinate.get(i).getKey()+" y:"+ board.positionCoordinate.get(i).getValue());
//        }
    }
}
