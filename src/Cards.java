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
            case 1:
                matchCards.append("Jack");
                break;
            case 2:
                matchCards.append("Ace");
                break;
            case 3:
                matchCards.append("Queen");
                break;
            case 4:
                matchCards.append("King");
                break;
            default:
                matchCards.append(rank);
                break;
        }

        matchCards.append(" of ");

        switch (suit){
            case 11:
                matchCards.append("Hearts");
                break;
            case 12:
                matchCards.append("Diamonds");
                break;
            case 13:
                matchCards.append("Clubs");
                break;
            case 14:
                matchCards.append("Spades");
                break;
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
