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
//        Matcher m = new And(
//                new Not(new HasAtLeast(1, "goals")),
//                new PlaysIn("NYR")
//        );
//        Matcher m = new And(
//                new HasFewerThan(1, "goals"),
//                new PlaysIn("NYR")
//        );
//        Matcher m = new And(new All());
//        Matcher m = new Or(new HasAtLeast(40, "goals"),
//                new HasAtLeast(60, "assists")
//        );
//        Matcher m = new And(
//                new HasAtLeast(50, "points"),
//                new Or(
//                        new PlaysIn("NYR"),
//                        new PlaysIn("NYI"),
//                        new PlaysIn("BOS")
//                )
//        );
        QueryBuilder query = new QueryBuilder();
        //Kaikki pelaajat
//        Matcher m = query.build();
        //Kaikki joiden joukkue NYR
//        Matcher m = query.playsIn("NYR").build();
        //kaikki joiden joukkue NYR ja vähintään 5 ja vähemmän kuin 10 maalia.
//        Matcher m = query.playsIn("NYR")
//                         .hasAtLeast(5, "goals")
//                         .hasFewerThan(10, "goals").build();
//        m = query.not(m).build();
        //Or testi
//        Matcher m = query.oneOf(query.playsIn("EDM")
//                .hasAtLeast(40, "points").build(),
//                query.playsIn("PHI")
//                        .hasAtLeast(10, "assists")
//                        .hasFewerThan(5, "goals").build()
//        ).build();

        Matcher m = query.not(
                query.oneOf(
                query.playsIn("PIT").hasAtLeast(20, "goals").build(),
                query.playsIn("WSH").hasAtLeast(20, "goals").build()
                ).build())
                .hasAtLeast(10, "assists")
                .build();
        List<Player> tulos = stats.matches(m);
        for (Player player : tulos) {
            System.out.println(player);
        }
        System.out.println(tulos.size());

    }
}
