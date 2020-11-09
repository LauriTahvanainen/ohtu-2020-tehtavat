package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players, Collections.reverseOrder());
        
        System.out.println("Suomalaisten NHL pelaajien tilastot:");
        for (Player player : players) {
            if (player.getNationality().equalsIgnoreCase("FIN")) {
                System.out.println(player);
            }
        }
    }
}
