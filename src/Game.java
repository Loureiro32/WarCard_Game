import Enums.InitialMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
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
        Card card1 = player1.pickCard();
        Card card2 = player2.pickCard();

        boolean isDraw = false;
        if (card1 == card2) {
            isDraw = true;
        }
        play(Collections.singletonList(new Card(3, 1)), Collections.singletonList(new Card(3, 1)), true);
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

    private void play(List<Card> card1, List<Card> card2, boolean isDraw) {
        if (player1.getCardsList().size() <= 3) {
            System.out.println(player2.getName() + " Wins!");
            return;
        }
        if (player2.getCardsList().size() <= 3) {
            System.out.println(player1.getName() + " Wins!");
            return;
        }

        if (card1.size() == 4) {
            isDraw = false;
        }

        if (!isDraw) {
            System.out.println(player1.getName() + " place " + player1.faceCard());
            System.out.println(player2.getName() + " place " + player2.faceCard());

            if (card1.getFirst().getRank() > card2.getFirst().getRank()) {
                changeDeckCards(card1, card2);
            }
            if (card1.getFirst().getRank() < card2.getFirst().getRank()) {
                changeDeckCards(card2, card1);
            }

            play(Collections.singletonList(player1.pickCard()), Collections.singletonList(player2.pickCard()), false);
        } else {
            card1.add(player1.pickCard());
            card2.add(player2.pickCard());
            play(card1, card2, true);
        }
    }

//    public void round(Player player1, Player player2) throws InterruptedException {
//        while (true) {
//
//            System.out.println("Round : " + roundCounter);
//            System.out.println(player1.getName() + " place " + player1.faceCard());
//            System.out.println(player2.getName() + " place " + player2.faceCard());
//            if (player1.playerCard() > player2.playerCard()) {
//                changeDeckCards(player1, player2, false);
//            } else if (player2.playerCard() > player1.playerCard()) {
//                changeDeckCards(player2, player1, false);
//            }
//            if (player1.playerCard() == player2.playerCard()) {
//                changeDeckCards(player1, player2, true);
//            }
//
//            if (player1.getCardsList().size() <= 3) {
//                System.out.println(player2.getName() + " Wins!");
//                break;
//            }
//            if (player2.getCardsList().size() <= 3) {
//                System.out.println(player1.getName() + " Wins!");
//                break;
//            }
//            Thread.sleep(1000);
//            roundCounter++;
//        }
//    }

    public void changeDeckCards(List<Card> winner, List<Card> looser) {
        System.out.println("Round : " + roundCounter);
        roundCounter++;

        for (int i = 0; i < winner.size(); i++) {
            player1.getCardsList().addLast(winner.get(i));
            player1.getCardsList().removeFirst();
            player1.getCardsList().addLast(looser.get(i));
            player2.getCardsList().removeFirst();
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