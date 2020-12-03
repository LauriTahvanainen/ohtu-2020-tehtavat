package ohtu.kps.logiikka;

public class PelaajaVsPelaaja extends KiviPaperiSakset {

    public PelaajaVsPelaaja(Tuomari tuomari) {
        super(tuomari);
    }

    @Override
    protected String toisenSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
}
