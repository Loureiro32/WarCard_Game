import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cardsList = new ArrayList<>();
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<Card> getCardsList() {
        return cardsList;
    }

    public String faceCard(){
       String faceCard = String.valueOf(getCardsList().getFirst());
        return faceCard;
    }

    public void setCardsList(List<Card> cardsList) {
        this.cardsList = cardsList;
    }
}
