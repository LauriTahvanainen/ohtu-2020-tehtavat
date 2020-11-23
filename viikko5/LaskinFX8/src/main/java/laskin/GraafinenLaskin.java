package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GraafinenLaskin extends Pane {

    public GraafinenLaskin() {
        super();
        
        VBox layout = new VBox(10);
        
        TextField tuloskentta = new TextField("0"); 
        tuloskentta.setEditable(false);
        TextField syotekentta = new TextField(""); 
        
        HBox napit = new HBox(10);
        
        Button plus = new Button("+");
        plus.setId("plus");
        
        Button miinus = new Button("-");
        miinus.setId("miinus");
        
        Button nollaa = new Button("Z");
        nollaa.setId("nollaa");
        nollaa.disableProperty().set(true);
        
        Button undo = new Button("undo"); 
        undo.setId("undo");
        undo.disableProperty().set(true);
        
        napit.getChildren().addAll(plus, miinus, nollaa, undo);
        
        Sovelluslogiikka sovellusLogiikka = new Sovelluslogiikka();
        GraafinenIO graafinenIO = new GraafinenIO(tuloskentta, syotekentta, nollaa, undo, plus, miinus);
        GraafinenKomentoPalvelu komentoPalvelu = new GraafinenKomentoPalvelu(graafinenIO, sovellusLogiikka);     
        Tapahtumankuuntelija kasittelija = new Tapahtumankuuntelija(komentoPalvelu);
        
        plus.setOnAction(kasittelija);
        miinus.setOnAction(kasittelija);
        nollaa.setOnAction(kasittelija);
        undo.setOnAction(kasittelija);
        
        layout.getChildren().addAll(tuloskentta, syotekentta, napit);   
        
        getChildren().add(layout);
    }
}
