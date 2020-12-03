package ohtu.kps.logiikka;

public class PelaajaVsTekoaly extends KiviPaperiSakset {
    
    private ITekoaly tekoaly;
    
    public PelaajaVsTekoaly(Tuomari tuomari, ITekoaly tekoaly) {
        super(tuomari);
        this.tekoaly = tekoaly;
    }

    @Override
    protected String toisenSiirto() {
        String siirto = this.tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        this.tekoaly.asetaSiirto(this.ensimmaisenSiirto);
        return siirto;
    }
}