import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final String PLAY_COLOR = "\u001B[32m";
    public static final String EXIT_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";

    List<Players> playersList = new ArrayList<Players>();

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