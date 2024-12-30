import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Cards> cardsList = new ArrayList<Cards>();
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<Cards> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Cards> cardsList) {
        this.cardsList = cardsList;
    }
}
