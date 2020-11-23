package laskin;

public class Nollaa extends Komento {

    public Nollaa(IO io, ISovelluslogiikka logiikka) {
        super(io, logiikka);
    }

    @Override
    public void suorita() {

        logiikka.nollaa();

        io.paivitaNakyma(logiikka.tulos());

        io.piilotaNollaus();
        io.naytaUndo();
    }

    @Override
    public void peru() {
        this.logiikka.peru();
        io.paivitaNakyma(logiikka.tulos());
        io.naytaNollaus();
        io.piilotaUndo();
    }

}
