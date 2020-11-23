package laskin;

public class Summa extends LaskuOperaatio {
    
    public Summa(IO io, ISovelluslogiikka logiikka) {
        super(io, logiikka);
    }

    @Override
    public void laske(int arvo) {
        this.logiikka.plus(arvo);
    }

    @Override
    public void peru() {
        this.logiikka.peru();
        this.paivitaNakyma();
        this.io.piilotaUndo();
    }

}
