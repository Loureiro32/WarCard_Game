import Enums.InitialMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final String GREEN_COLOR = "\u001B[32m";
    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";
    protected Player[] player = new Player[2];
    private int roundCounter = 0;

    public Game() {
        this.player[0] = new Player("Hugo");
        this.player[1] = new Player("Loureiro");

    }

    public void startGame() {
        Player player1 = player[0];
        Player player2 = player[1];

        System.out.println(GREEN_COLOR + player1.getName() + RESET_COLOR + RED_COLOR + " VS "
                + RESET_COLOR + GREEN_COLOR + player2.getName() + RESET_COLOR);

        giveCards(player1, player2);
        round(player1, player2);
    }


    public void giveCards(Player player1, Player player2) {
        //! new method InitialDeck
        List<Card> cardDeck = new ArrayList<>();

        for (int x = 2; x < 15; x++) {
            for (int y = 0; y < 4; y++) {
                cardDeck.add(new Card(x, y));
            }
        }
        System.out.println(cardDeck.size());

        //! --------###------

        shuffleDeck(cardDeck);

        int deckSize = cardDeck.size() / 2;
        List<Card> deck1 = new ArrayList<>(cardDeck.subList(0, deckSize));
        List<Card> deck2 = new ArrayList<>(cardDeck.subList(deckSize, cardDeck.size()));

        player1.setCardsList(deck1);
        player2.setCardsList(deck2);

        System.out.println(GREEN_COLOR + player1.getName() + " DECK -->" + RESET_COLOR + player1.getCardsList());
        System.out.println(RED_COLOR + player2.getName() + " DECK -->" + RESET_COLOR + player2.getCardsList());

    }

    public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }


    public void round(Player player1, Player player2) {
        while (player1.getCardsList() != null || player2.getCardsList() != null) {

            System.out.println("Round : " + roundCounter);
            System.out.println("Player " + player1.getName() + " place " + player1.faceCard());
            System.out.println("Player " + player2.getName() + " place " + player2.faceCard());

            if (player1.playerCard() > player2.playerCard()) {
                player1.getCardsList().addLast(player1.getCardsList().getFirst());
                player1.getCardsList().removeFirst();
                player1.getCardsList().addLast(player2.getCardsList().getFirst());
                player2.getCardsList().removeFirst();
                System.out.println(player1.getCardsList().size());
                System.out.println(player2.getCardsList().size());

            } else if (player2.playerCard() > player1.playerCard()) {
                player2.getCardsList().addLast(player2.getCardsList().getFirst());
                player2.getCardsList().removeFirst();
                player2.getCardsList().addLast(player1.getCardsList().getFirst());
                player1.getCardsList().removeFirst();
                System.out.println(player1.getCardsList().size());
                System.out.println(player2.getCardsList().size());
            }

            if (player1.playerCard() == player2.playerCard()) {

            }

            roundCounter++;
            break;
        }
    }

    public void menu() {

        Scanner input = new Scanner(System.in);
        System.out.println(GREEN_COLOR + " PLAY " + RESET_COLOR + "\n"
                + RED_COLOR + " EXIT" + RESET_COLOR);

        String userInput = input.nextLine().toUpperCase();
        InitialMenu choice = InitialMenu.valueOf(userInput);

        switch (choice) {
            case PLAY -> startGame();
            case EXIT -> System.exit(1);
        }
    }

}