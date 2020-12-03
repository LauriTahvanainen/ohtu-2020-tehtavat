package ohtu.kps.logiikka;

public class PeliTehdas {

    public static KiviPaperiSakset pelaajaVastaanPelaaja() {
        return new PelaajaVsPelaaja(new Tuomari("Ensimmäinen pelaaja", "Toinen pelaaja"));
    }

    public static KiviPaperiSakset pelaajaVastaanTekoaly() {
        return new PelaajaVsTekoaly(new Tuomari("Ensimmäinen pelaaja", "Tietokone"), new Tekoaly());
    }

    public static KiviPaperiSakset pelaajaVastaanParannettuTekoaly() {
        return new PelaajaVsTekoaly(new Tuomari("Ensimmäinen pelaaja", "Tietokone"), new TekoalyParannettu(20));
    }
}
