package laskin;

public class Erotus extends LaskuOperaatio {
    
    public Erotus(IO io, ISovelluslogiikka logiikka) {
        super(io, logiikka);
    }

    @Override
    public void laske(int arvo) {
        this.logiikka.miinus(arvo);
    }

    @Override
    public void peru() {
        this.logiikka.peru();
        this.paivitaNakyma();
        io.piilotaUndo();
    }


}
