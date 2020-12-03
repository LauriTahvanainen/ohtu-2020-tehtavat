package statistics;

import java.util.List;
import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

//        Matcher m = new And( new HasAtLeast(5, "goals"),
//                             new HasAtLeast(5, "assists"),
//                             new PlaysIn("PHI")
//        );
        Matcher m = new And(
                new Not(new HasAtLeast(1, "goals")),
                new PlaysIn("NYR")
        );

//        Matcher m = new And(
//                new HasFewerThan(1, "goals"),
//                new PlaysIn("NYR")
//        );

//        Matcher m = new And(new All());

        List<Player> tulos = stats.matches(m);
        System.out.println(tulos.size());
        for (Player player : tulos) {
            System.out.println(player);
        }
    }
}
