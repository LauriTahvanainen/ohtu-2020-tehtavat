package laskin;

public abstract class LaskuOperaatio extends Komento {

    public LaskuOperaatio(IO io, ISovelluslogiikka logiikka) {
        super(io, logiikka);
    }

    @Override
    public void suorita() {
        int arvo = io.getSyote();

        int laskunTulos = laske(arvo);

        io.paivitaNakyma(laskunTulos);

        if (laskunTulos == 0) {
            io.piilotaNollaus();
        } else {
            io.naytaNollaus();
        }
        io.naytaUndo();
    }
    
    public abstract int laske(int arvo);

}
