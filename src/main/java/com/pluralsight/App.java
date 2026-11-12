package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the dealer: ");
        String name1 = scanner.nextLine();

        System.out.println("Enter the name of the player: ");
        String name2 = scanner.nextLine();

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        System.out.println("Welcome, " + player1.getPlayer() + " and " + player2.getPlayer());

        Deck deck = new Deck();
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            player1.getHand().deal(deck.deal());
            player2.getHand().deal(deck.deal());
        }

        int value1 = player1.getHand().getValue();
        int value2 = player2.getHand().getValue();

        System.out.println(player1.getPlayer() + "'s hand: " + player1.getHand() + "value: " + value1);
        System.out.println(player2.getPlayer() + "'s hand: " + player2.getHand() + "value: " + value2);

        if (value1 > 21 && value2 > 21) {
            System.out.println("Both are busted! No winner!");
        } else if (value1 > 21) {
            System.out.println(player2.getPlayer() + " is the winner!");
        } else if (value2 > 21) {
            System.out.println(player1.getPlayer() + " is the winner!");
        } else if (value1 > value2) {
            System.out.println(player1.getPlayer() + " is the winner with " + value1 + " value");
        } else if (value2 > value1) {
            System.out.println(player2.getPlayer() + " is the winner with " + value2 + " value");
        } else {
            System.out.println("You both are tied!");
        }
    }
}
