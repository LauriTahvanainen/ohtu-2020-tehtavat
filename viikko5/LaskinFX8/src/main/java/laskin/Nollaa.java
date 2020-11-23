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
        io.naytaNollaus();
    }

    @Override
    public void peru() {
    }

}
