package laskin;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Tuntematon extends Komento {

    public Tuntematon(IO io, ISovelluslogiikka logiikka) {
        super(io, logiikka);
    }

    @Override
    public void suorita() {
        Alert alert = new Alert(AlertType.WARNING, "Toiminto ei vielä tuettu!");
        alert.showAndWait();
    }

    @Override
    public void peru() {
        Alert alert = new Alert(AlertType.WARNING, "Toiminto ei vielä tuettu!");
        alert.showAndWait();
    }

}
