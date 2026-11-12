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


    }
}
