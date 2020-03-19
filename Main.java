package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Player player = new Player();
    private static Scanner scan = new Scanner(System.in);
    private static Random random = new Random();
    private static int pos;
    private static int rand;

    public static void main(String[] args) {

        char[][] design = {{' ', '|', ' ', '|', ' '},
                {'-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' '},};

        System.out.println("Welcome to the Game Board:");
        gameUI(design);
        while(true){
            System.out.print("Enter your placement:");
            pos = scan.nextInt();
            while(player.playerPos.contains(pos) || player.cpuPos.contains(pos)){
                System.out.println("Position is taken. Enter correct position.");
                pos = scan.nextInt();
            }

            player.playGame(design, pos, "player");
            System.out.println();
            String result = player.checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }

            rand = random.nextInt(9) + 1;
            while(player.playerPos.contains(rand) || player.cpuPos.contains(rand)){
                rand = random.nextInt(9)+1;
            }
            player.playGame(design, rand, "cpu");

            gameUI(design);


        }

    }
    private static void gameUI(char[][] design){
        for(char[] forDesign:design){
            for(char forPrint:forDesign){
                System.out.print(forPrint);
            }
            System.out.println();
        }
    }
}
