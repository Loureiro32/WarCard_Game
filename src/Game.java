import Enums.InitialMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final String PLAY_COLOR = "\u001B[32m";
    public static final String EXIT_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";

    protected Player[] player = new Player[2];

    public Game(){
        this.player[0] = new Player("Hugo");
        this.player[1] = new Player("Ricardo");

    }

    public void startGame(){
        Player player1 = player[0];
        Player player2 = player[1];

        System.out.println(PLAY_COLOR + player1.getName()+ RESET_COLOR + EXIT_COLOR + " VS "
                + RESET_COLOR + PLAY_COLOR + player2.getName() + RESET_COLOR);

        //giveCards(player1, player2);
    }


    public void giveCards(){

        List<Card> cardDeck = new ArrayList<>();

        for(int x = 0; x<13; x++){
            for(int y = 0; y<4; y++){
                cardDeck.add(new Card(x,y));
            }
        }

        System.out.println(cardDeck.size());//52/26
        System.out.println(cardDeck);

        for(int i =0; i<= 52; i++) {
            int random = (int) (Math.random() * cardDeck.size() - 1) + 1;
            System.out.println(random);
        }
    }

    public void menu(){

        Scanner input = new Scanner(System.in);
        System.out.println(PLAY_COLOR + " PLAY " +RESET_COLOR + "\n"
              + EXIT_COLOR + " EXIT" + RESET_COLOR );

        String userInput = input.nextLine().toUpperCase();
        InitialMenu choice = InitialMenu.valueOf(userInput);

        switch (choice){
            case PLAY -> startGame();
            case EXIT -> System.exit(1);
        }
    }

}