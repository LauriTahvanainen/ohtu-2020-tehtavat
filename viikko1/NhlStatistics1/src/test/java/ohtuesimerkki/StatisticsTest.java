/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author coronatus
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }

    };

    Statistics stats;

    @Before
    public void setUp() {
        this.stats = new Statistics(readerStub);
    }

    @Test
    public void searchWithExistingPlayerReturnsRightPlayer() {
        Player actual = this.stats.search("Kurri");
        assertEquals(new Player("Kurri", "EDM", 37, 53), actual);
    }

    @Test
    public void searchWithNonExistentPlayerReturnsNull() {
        Player actual = this.stats.search("Crosby");
        assertEquals(null, actual);
    }

    @Test
    public void teamsWithExistentTeamNameReturnsRightList() {
        List<Player> actual = this.stats.team("EDM");
        List<Player> expected = Arrays.asList(new Player("Semenko", "EDM", 4, 12), new Player("Kurri", "EDM", 37, 53), new Player("Gretzky", "EDM", 35, 89));

        assertThat(actual, is(expected));
    }

    @Test
    public void teamsWithNonExistenTeamNameReturnsEmptyList() {
        List<Player> actual = this.stats.team("FLA");
        assertTrue(actual.isEmpty());
    }

    @Test
    public void topScorersWithNegativeNumberReturnsEmptyList() {
        List<Player> actual = this.stats.topScorers(-2);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void topScorersReturnsRightAmountOfPlayers() {
        List<Player> actual = this.stats.topScorers(3);
        assertEquals(3, actual.size());
    }

    @Test
    public void topScorersWithMoreAskedThanInDatabaseReturnsAllThePlayers() {
        List<Player> actual = this.stats.topScorers(10);
        assertEquals(5, actual.size());
    }

    @Test
    public void topScorersReturnsPlayersInRightOrder() {
        List<Player> actual = this.stats.topScorers(4);
        List<Player> expected = Arrays.asList(new Player("Gretzky", "EDM", 35, 89), new Player("Lemieux", "PIT", 45, 54), new Player("Yzerman", "DET", 42, 56), new Player("Kurri", "EDM", 37, 53));

        assertThat(actual, is(expected));
    }

}
