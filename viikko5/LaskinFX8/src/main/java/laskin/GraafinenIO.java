package laskin;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GraafinenIO implements IO {

    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button plus;
    protected Button miinus;
    protected Button nollaa;
    protected Button undo;

    public GraafinenIO(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Button plus, Button miinus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.miinus = miinus;
        this.plus = plus;
    }

    @Override
    public void piilotaNollaus() {
        nollaa.disableProperty().set(true);
    }

    @Override
    public void naytaNollaus() {
        nollaa.disableProperty().set(false);
    }

    @Override
    public void naytaUndo() {
        undo.disableProperty().set(false);
    }

    @Override
    public void piilotaUndo() {
        undo.disableProperty().set(true);
    }

    @Override
    public void paivitaNakyma(int laskunTulos) {
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public int getSyote() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (NumberFormatException e) {
            Alert virhe = new Alert(AlertType.ERROR, "Syötä vain kokonaislukuja!");
            virhe.showAndWait();
        }
        return arvo;
    }

    @Override
    public String haeSummaKomponentti() {
        return this.plus.getId();
    }

    @Override
    public String haeNollausKomponentti() {
        return this.nollaa.getId();
    }

    @Override
    public String haeErotusKomponentti() {
        return this.miinus.getId();
    }

    @Override
    public String haeUndoKomponentti() {
        return this.undo.getId();
    }
}
