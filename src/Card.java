public class Card {
    private int suit;
    private int rank;

    public Card(int rank, int suit) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        StringBuilder matchCards = new StringBuilder();

        switch (rank){
            case 0 -> matchCards.append("Jack");
            case 1 -> matchCards.append("Ace");
            case 2 -> matchCards.append("Queen");
            case 3 -> matchCards.append("King");
            case 4 -> matchCards.append("2");
            case 5 -> matchCards.append("3");
            case 6 -> matchCards.append("4");
            case 7 -> matchCards.append("5");
            case 8 -> matchCards.append("6");
            case 9 -> matchCards.append("7");
            case 10 -> matchCards.append("8");
            case 11 -> matchCards.append("9");
            case 12 -> matchCards.append("10");
        }

        matchCards.append(" of ");

        switch (suit){
            case 0 -> matchCards.append("Hearts");
            case 1 -> matchCards.append("Diamonds");
            case 2 -> matchCards.append("Clubs");
            case 3 -> matchCards.append("Spades");
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
