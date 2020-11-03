
package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class Kirjanpito implements IKirjanpito {
    
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        this.tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}