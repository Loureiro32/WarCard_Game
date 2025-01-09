import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private List<Card> cardsList = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Card> cardsList) {
        this.cardsList = cardsList;
    }

    public String faceCard() {
        String faceCard = String.valueOf(getCardsList().getFirst());
        return faceCard;
    }

    public int pickCard() {
        return cardsList.getFirst().getRank();
    }
}