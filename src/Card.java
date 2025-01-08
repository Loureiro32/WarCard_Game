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

        switch (rank) {
            case 2 -> matchCards.append("2");
            case 3 -> matchCards.append("3");
            case 4 -> matchCards.append("4");
            case 5 -> matchCards.append("5");
            case 6 -> matchCards.append("6");
            case 7 -> matchCards.append("7");
            case 8 -> matchCards.append("8");
            case 9 -> matchCards.append("9");
            case 10 -> matchCards.append("10");
            case 11 -> matchCards.append("A");
            case 12 -> matchCards.append("J");
            case 13 -> matchCards.append("Q");
            case 14 -> matchCards.append("K");
        }

        matchCards.append(" ");

        switch (suit) {
            case 0 -> matchCards.append(Colors.RED + "❤" + Colors.Default);
            case 1 -> matchCards.append(Colors.RED + "◆" + Colors.Default);
            case 2 -> matchCards.append(Colors.BLACK + "♣" + Colors.Default);
            case 3 -> matchCards.append(Colors.BLACK + "♠" + Colors.Default);
        }
        return matchCards.toString();
    }

    public int getRank() {
        return rank;
    }

}
