package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Tapahtumankuuntelija implements EventHandler {

    private GraafinenKomentoPalvelu komentoPalvelu;

    public Tapahtumankuuntelija(GraafinenKomentoPalvelu komentoPalvelu) {
        this.komentoPalvelu = komentoPalvelu;
    }
    
    @Override
    public void handle(Event event) {
        Button painettuNappi = (Button) event.getTarget();
        this.komentoPalvelu.SuoritaKysyttyKomento(painettuNappi.getId());
    }

}
