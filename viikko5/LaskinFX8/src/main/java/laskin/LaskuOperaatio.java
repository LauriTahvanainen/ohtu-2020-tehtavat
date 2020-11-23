package laskin;

public abstract class LaskuOperaatio extends Komento {
    
    public LaskuOperaatio(IO io, ISovelluslogiikka logiikka) {
        super(io, logiikka);
    }

    @Override
    public void suorita() {
        int arvo = io.getSyote();

        laske(arvo);
        
        paivitaNakyma();
        io.naytaUndo();
    }
    
    public abstract void laske(int arvo);

    public void paivitaNakyma() {
        int tulos = logiikka.tulos();
        io.paivitaNakyma(tulos);

        if (tulos == 0) {
            io.piilotaNollaus();
        } else {
            io.naytaNollaus();
        }
     }
}
