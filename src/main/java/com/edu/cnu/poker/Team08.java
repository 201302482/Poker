package com.edu.cnu.poker;

import java.util.Scanner;

/**
 * Created by AD2S on 2017-04-25.
 */
public class Team08 {
    public static void main(String[] args) {
        Game game;
        Scanner scan = new Scanner(System.in);

        System.out.printf("포커게임을 시작합니다. ");

        while(true){
            System.out.printf("게임방식을 선택해주세요.\n\t[1]PokerType.FIVE\t[2]PokerType.SEVEN : ");
            int integerPokerType = scan.nextInt();
            if (integerPokerType == 1){
                game = new Game(PokerType.FIVE);
                break;
            } else if (integerPokerType == 2) {
                game = new Game(PokerType.SEVEN);
                break;
            }
        }
        game.run();
    }
}
