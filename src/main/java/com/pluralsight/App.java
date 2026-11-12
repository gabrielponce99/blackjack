package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the dealer: ");
        String name1 = scanner.nextLine();

        System.out.println("Enter the name of the player: ");
        String name2 = scanner.nextLine();

        Player dealer = new Player(name1);
        Player player = new Player(name2);

        System.out.println("Welcome, " + dealer.getPlayer() + " and " + player.getPlayer());

        Deck deck = new Deck();
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            dealer.getHand().deal(deck.deal());
            player.getHand().deal(deck.deal());
        }

        int dealerValue = dealer.getHand().getValue();
        int playerValue = player.getHand().getValue();

        System.out.println(dealer.getPlayer() + "'s hand: " + dealer.getHand() + "value: " + dealerValue);
        System.out.println(player.getPlayer() + "'s hand: " + player.getHand() + "value: " + playerValue);
        System.out.println();

        askToHit(dealer, scanner, deck, player);

        dealerValue = dealer.getHand().getValue();
        playerValue = player.getHand().getValue();

        System.out.println(dealer.getPlayer() + "'s hand: " + dealer.getHand() + "value: " + dealerValue);
        System.out.println(player.getPlayer() + "'s hand: " + player.getHand() + "value: " + playerValue);
        System.out.println();

        if (dealerValue > 21 && playerValue > 21) {
            System.out.println("Both are busted! No winner!");
        } else if (dealerValue > 21) {
            System.out.println(player.getPlayer() + " is the winner!");
        } else if (playerValue > 21) {
            System.out.println(dealer.getPlayer() + " is the winner!");
        } else if (dealerValue > playerValue) {
            System.out.println(dealer.getPlayer() + " is the winner with " + dealerValue + " value");
        } else if (playerValue > dealerValue) {
            System.out.println(player.getPlayer() + " is the winner with " + playerValue + " value");
        } else {
            System.out.println("You both are tied!");
        }
    }

    private static void askToHit(Player dealer, Scanner scanner, Deck deck, Player player) {
        if (dealer.getHand().getValue() < 16) {
            System.out.println(dealer.getPlayer() + ", Do you want to hit? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("yes") || answer.equals("y")) {
                while (dealer.getHand().getValue() < 16) {
                    System.out.println(dealer.getPlayer() + " is hitting!");
                    System.out.println();
                    dealer.getHand().deal(deck.deal());
                }
            } else if (answer.equals("no") || answer.equals("yes")) {
                System.out.println(dealer.getPlayer() + " is not hitting!");
                System.out.println();
            }
        }

        if (player.getHand().getValue() < 16) {
            System.out.println(player.getPlayer() + ", Do you want to hit? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("yes") || answer.equals("y")) {
                while (player.getHand().getValue() < 16) {
                    System.out.println(player.getPlayer() + " is hitting!");
                    System.out.println();
                    player.getHand().deal(deck.deal());
                }
            } else if (answer.equals("no") || answer.equals("yes")) {
                System.out.println(player.getPlayer() + " is not hitting!");
                System.out.println();
            }
        }
    }
}
