package ohtu.kps.logiikka;

import java.util.Scanner;
import static ohtu.kps.vakiot.Vakiot.*;


public abstract class KiviPaperiSakset {

    protected static final Scanner scanner = new Scanner(System.in);
    
    protected String ensimmaisenSiirto;
    
    protected Tuomari tuomari;
    
    protected KiviPaperiSakset(Tuomari tuomari) {
        this.tuomari = tuomari;
    }

    public void pelaa() {
        ensimmaisenSiirto = ensimmaisenSiirto();
        String toisenSiirto = toisenSiirto();

        while (onkoOkSiirto(ensimmaisenSiirto) && onkoOkSiirto(toisenSiirto)) {
            tuomari.kirjaaSiirto(ensimmaisenSiirto, toisenSiirto);
            System.out.println();
            System.out.println(tuomari.viimeisinTulos());
            System.out.println();
            System.out.println(tuomari.toString());
            System.out.println();
            
            ensimmaisenSiirto = ensimmaisenSiirto();
            toisenSiirto = toisenSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari.toString());
        System.out.println();
    }

    protected String ensimmaisenSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    
    abstract protected String toisenSiirto();

    protected static boolean onkoOkSiirto(String siirto) {
        return siirto.equals(KIVI) || siirto.equals(SAKSET) || siirto.equals(PAPERI);
    }
}
