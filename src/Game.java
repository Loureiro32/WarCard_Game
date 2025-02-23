import Enums.InitialMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private int roundCounter = 0;

    public Game() {
        this.player1 = new Player("Hugo");
        this.player2 = new Player("Loureiro");
    }

    private void startGame() {
        List<Card> cardDeck = new ArrayList<>();

        System.out.println(Colors.GREEN + player1.getName() + Colors.Default + Colors.RED + " VS "
                + Colors.Default + Colors.GREEN + player2.getName() + Colors.Default);

        initialDeck(cardDeck);
        shuffleDeck(cardDeck);
        giveCards(cardDeck);
        round();
    }

    private void initialDeck(List<Card> initialDeck) {
        for (int x = 2; x < 15; x++) {
            for (int y = 0; y < 4; y++) {
                initialDeck.add(new Card(x, y));
            }
        }
    }

    private void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    private void giveCards(List<Card> initialDeck) {

        int deckSize = initialDeck.size() / 2;
        List<Card> deck1 = new ArrayList<>(initialDeck.subList(0, deckSize));
        List<Card> deck2 = new ArrayList<>(initialDeck.subList(deckSize, initialDeck.size()));

        player1.setCardsList(deck1);
        player2.setCardsList(deck2);

        System.out.println(Colors.GREEN + player1.getName() + " DECK -->" + Colors.Default + player1.getCardsList());
        System.out.println(Colors.RED + player2.getName() + " DECK -->" + Colors.Default + player2.getCardsList());
    }

    public void round() {
        while (!player1.getCardsList().isEmpty() || !player2.getCardsList().isEmpty()) {

            System.out.println("Round : " + roundCounter);
            System.out.println(player1.getName() + " place " + player1.faceCard());
            System.out.println(player2.getName() + " place " + player2.faceCard());
            if (player1.pickCard() > player2.pickCard()) {
                changeDeckCards(player1, player2);
            } else if (player2.pickCard() > player1.pickCard()) {
                changeDeckCards(player2, player1);
            }
            if (player1.pickCard() == player2.pickCard()) {
                System.out.println("It's a tie! Contesting the tie...");
                contestTie(player1, player2);
            }
            if (player1.getCardsList().size() <= 3) {
                System.out.println(player2.getName() + " Wins!");
                break;
            } else if (player2.getCardsList().size() <= 3) {
                System.out.println(player1.getName() + " Wins!");
                break;
            }
            roundCounter++;
        }
    }

    private void changeDeckCards(Player winner, Player loser) {
        winner.getCardsList().addLast(winner.getCardsList().getFirst());
        winner.getCardsList().removeFirst();
        winner.getCardsList().addLast(loser.getCardsList().getFirst());
        loser.getCardsList().removeFirst();

    }

    private void contestTie(Player player1, Player player2) {
        List<Card> player1WarCards = new ArrayList<>();
        List<Card> player2WarCards = new ArrayList<>();

        player1WarCards.add(player1.getCardsList().getFirst());
        player2WarCards.add(player2.getCardsList().getFirst());

        tieTakeCard(player1WarCards, player2WarCards);

        Card lastCard1 = player1WarCards.getLast();
        Card lastCard2 = player2WarCards.getLast();

        if (lastCard1.getRank() > lastCard2.getRank()) {
            System.out.println(player1.getName() + " place " + player1WarCards.getLast());
            System.out.println(player2.getName() + " place " + player2WarCards.getLast());
            System.out.println(player1.getName() + " wins the tie!");
            player1.getCardsList().addAll(player1WarCards);
            player1.getCardsList().addAll(player2WarCards);

        } else if (lastCard1.getRank() < lastCard2.getRank()) {
            System.out.println(player1.getName() + " place " + player1WarCards.getLast());
            System.out.println(player2.getName() + " place " + player2WarCards.getLast());
            System.out.println(player2.getName() + " wins the tie!");
            player2.getCardsList().addAll(player1WarCards);
            player2.getCardsList().addAll(player2WarCards);

        } else {
            System.out.println("Other Tie");
            contestTie(player1, player2);
        }
    }

    private void tieTakeCard(List<Card> player1WarCards, List<Card> player2WarCards) {
        for (int i = 0; i < 3; i++) {
            Card p1Card = player1.getCardsList().getFirst();
            Card p2Card = player2.getCardsList().getFirst();
            player1.getCardsList().removeFirst();
            player2.getCardsList().removeFirst();

            if (p1Card != null) {
                player1WarCards.add(p1Card);

            }
            if (p2Card != null) {
                player2WarCards.add(p2Card);
            }
        }
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