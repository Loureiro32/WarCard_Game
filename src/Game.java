import Enums.InitialMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player[] player = new Player[2];
    private int roundCounter = 0;

    public Game() {
        this.player[0] = new Player("Hugo");
        this.player[1] = new Player("Loureiro");

    }

    public void startGame() {
        Player player1 = player[0];
        Player player2 = player[1];
        List<Card> cardDeck = new ArrayList<>();

        System.out.println(Colors.GREEN + player1.getName() + Colors.Default + Colors.RED + " VS "
                + Colors.Default + Colors.GREEN + player2.getName() + Colors.Default);

        try {
            initialDeck(cardDeck);
            shuffleDeck(cardDeck);
            giveCards(player1, player2, cardDeck);
            round(player1, player2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void giveCards(Player player1, Player player2, List<Card> initialDeck) {

        int deckSize = initialDeck.size() / 2;
        List<Card> deck1 = new ArrayList<>(initialDeck.subList(0, deckSize));
        List<Card> deck2 = new ArrayList<>(initialDeck.subList(deckSize, initialDeck.size()));

        player1.setCardsList(deck1);
        player2.setCardsList(deck2);

        System.out.println(Colors.GREEN + player1.getName() + " DECK -->" + Colors.Default + player1.getCardsList());
        System.out.println(Colors.RED + player2.getName() + " DECK -->" + Colors.Default + player2.getCardsList());

    }

    public void initialDeck(List<Card> initialDeck) {
        for (int x = 2; x < 15; x++) {
            for (int y = 0; y < 4; y++) {
                initialDeck.add(new Card(x, y));
            }
        }
    }

    public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    public void round(Player player1, Player player2) throws InterruptedException {
        while (true) {

            System.out.println("Round : " + roundCounter);
            System.out.println(player1.getName() + " place " + player1.faceCard());
            System.out.println(player2.getName() + " place " + player2.faceCard());
            if (player1.playerCard() > player2.playerCard()) {
                changeDeckCards(player1, player2);
            } else if (player2.playerCard() > player1.playerCard()) {
                changeDeckCards(player2, player1);
            }
//            if (player1.playerCard() == player2.playerCard()) {
//
//            }

            if (player1.getCardsList().size() <= 3) {
                System.out.println(player2.getName() + " Wins!");
                break;
            }
            if (player2.getCardsList().size() <= 3) {
                System.out.println(player1.getName() + " Wins!");
                break;
            }
            Thread.sleep(1000);
            roundCounter++;
        }
    }

    public void changeDeckCards(Player roundWinner, Player roundLoser) {
        roundWinner.getCardsList().addLast(roundWinner.getCardsList().getFirst());
        roundWinner.getCardsList().removeFirst();
        roundWinner.getCardsList().addLast(roundLoser.getCardsList().getFirst());
        roundLoser.getCardsList().removeFirst();
    }

    public void menu() {

        Scanner input = new Scanner(System.in);
        System.out.println(Colors.GREEN + " PLAY " + Colors.Default + "\n"
                + Colors.RED + " EXIT " + Colors.Default + "\n"
                + Colors.PURPLE + " LOAD " + Colors.Default);

        String userInput = input.nextLine().toUpperCase();
        InitialMenu choice = InitialMenu.valueOf(userInput);

        switch (choice) {
            case PLAY -> startGame();
            case EXIT -> System.exit(1);
            case LOAD -> System.out.println("Coming Soon");
        }
    }

}