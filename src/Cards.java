import java.net.DatagramPacket;

public class Cards {
    private int suit;
    private int rank;

    public Cards(int rank, int suit) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        StringBuilder matchCards = new StringBuilder();

        switch (rank){
            case 1 -> matchCards.append("Jack");
            case 2 -> matchCards.append("Ace");
            case 3 -> matchCards.append("Queen");
            case 4 -> matchCards.append("King");
            default -> matchCards.append(rank);
        }

        matchCards.append(" of ");

        switch (suit){
            case 10 -> matchCards.append("Hearts");
            case 11 -> matchCards.append("Diamonds");
            case 12 -> matchCards.append("Clubs");
            case 13 -> matchCards.append("Spades");
        }
       return matchCards.toString();
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }
}
