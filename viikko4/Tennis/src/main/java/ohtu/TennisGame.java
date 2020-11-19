package ohtu;

public class TennisGame {

    private final static int POINTS_TO_WIN_GAME_OR_ADVANTAGE = 4;
    private final static int MIN_POINTS_DIFF_TO_WIN = 2;

    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            player1Points += 1;
        } else if (playerName.equals(this.player2Name)) {
            player2Points += 1;
        } else {
            throw new IllegalArgumentException("Player-name not one of players. Players: " + this.player1Name + " : " + this.player2Name + ". Given: " + playerName);
        }
    }

    public String gameEvenToScore() {
        switch (player1Points) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public String playerPointsToScore(int playerPoints) {
        switch (playerPoints) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    public String winOrAdvantageToScore() {
        int pointsDifference = player1Points - player2Points;
        if (pointsDifference == 1) {
            return "Advantage player1";
        } else if (pointsDifference == -1) {
            return "Advantage player2";
        } else if (pointsDifference >= MIN_POINTS_DIFF_TO_WIN) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public String getScore() {
        if (player1Points == player2Points) {
            return gameEvenToScore();
        } else if (player1Points >= POINTS_TO_WIN_GAME_OR_ADVANTAGE || player2Points >= POINTS_TO_WIN_GAME_OR_ADVANTAGE) {
            return winOrAdvantageToScore();
        } else {
            return playerPointsToScore(player1Points) + "-" + playerPointsToScore(player2Points);
        }
    }
}
