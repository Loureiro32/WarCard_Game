import Enums.InitialMenu;
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

    public void play(){}

    public void menu(){

        Scanner input = new Scanner(System.in);
        System.out.println(PLAY_COLOR + " PLAY " +RESET_COLOR + "\n"
              + EXIT_COLOR + " EXIT" );

        String userInput = input.nextLine().toUpperCase();
        InitialMenu choice = InitialMenu.valueOf(userInput);

        switch (choice){
            case PLAY -> play();
            case EXIT -> System.exit(1);
        }
    }

}