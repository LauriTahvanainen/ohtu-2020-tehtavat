package ohtu.kps.logiikka;

import static ohtu.kps.vakiot.Vakiot.*;

/**
 * Helppo tekoäly
 */
public class Tekoaly implements ITekoaly {

    int siirto;

    public Tekoaly() {
        siirto = 0;
    }

    @Override
    public String annaSiirto() {
        siirto++;
        int jakojaannos = siirto % 3;

        switch (jakojaannos) {
            case 0:
                return KIVI;
            case 1:
                return PAPERI;
            default:
                return SAKSET;
        }
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}
