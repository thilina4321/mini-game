package com.company;

import javax.print.attribute.IntegerSyntax;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {

     ArrayList<Integer> playerPos = new ArrayList<Integer>();
     ArrayList<Integer> cpuPos = new ArrayList<Integer>();

    public void playGame(char[][] design, int pos, String player){

        char symbol = ' ';
        if(player.equals("player")){
            playerPos.add(pos);
            symbol = 'X';
        }else if(player.equals("cpu")) {
            symbol = 'O';
            cpuPos.add(pos);

        }

        switch(pos){
            case 1: design[0][0] = symbol;
                    break;
            case 2: design[0][2] = symbol;
                break;
            case 3: design[0][4] = symbol;
                break;
            case 4: design[2][0] = symbol;
                break;
            case 5: design[2][2] = symbol;
                break;
            case 6: design[2][4] = symbol;
                break;
            case 7: design[4][0] = symbol;
                break;
            case 8: design[4][2] = symbol;
                break;
            case 9: design[4][4] = symbol;
                break;
            default:
                break;
        }

    }
    public String checkWinner(){

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List topCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List botCol = Arrays.asList(3,6,9);
        List crossX = Arrays.asList(1,5,9);
        List crossY = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(topCol);
        winning.add(midCol);
        winning.add(botCol);
        winning.add(crossX);
        winning.add(crossY);

        for(List list:winning){
            if(playerPos.containsAll(list)){
                return "Congratulation you Won...";
            }else if(cpuPos.containsAll(list)){
                return "Cpu Won...";
            }else if(playerPos.size()+cpuPos.size()== 9){
                return "Game is tied....";
            }
        }

        return "";
    }
}
