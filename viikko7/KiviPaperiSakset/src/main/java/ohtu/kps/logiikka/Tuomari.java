package ohtu.kps.logiikka;

/**
 * Tuomari pitää kirjaa pisteytyksestä
 */
public class Tuomari {

    private String pelaaja1;
    private String pelaaja2;
    private int pisteet1;
    private int pisteet2;
    private int tasapelit;
    private String viimeisinTulos;

    public Tuomari(String pelaaja1, String pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
        this.pisteet1 = 0;
        this.pisteet2 = 0;
        this.tasapelit = 0;
    }

    public void kirjaaSiirto(String ekanSiirto, String tokanSiirto) {
        if (tasapeli(ekanSiirto, tokanSiirto)) {
            tasapelit++;
            this.viimeisinTulos = "Tasapeli!";
        } else if (ekaVoittaa(ekanSiirto, tokanSiirto)) {
            pisteet1++;
            this.viimeisinTulos = pelaaja1 + " voitti!";
        } else {
            pisteet2++;
            this.viimeisinTulos = pelaaja2 + " voitti!";
        }
    }

    private static boolean tasapeli(String eka, String toka) {
        if (eka.equals(toka)) {
            return true;
        }

        return false;
    }

    private static boolean ekaVoittaa(String eka, String toka) {
        if ("k".equals(eka) && "s".equals(toka)) {
            return true;
        } else if ("s".equals(eka) && "p".equals(toka)) {
            return true;
        } else if ("p".equals(eka) && "k".equals(toka)) {
            return true;
        }

        return false;
    }

    public String viimeisinTulos() {
        return viimeisinTulos;
    }

    @Override
    public String toString() {
        return "Pelitilanne: " + pisteet1 + " - " + pisteet2 + "\n"
                + "Tasapelit: " + tasapelit;
    }
}
