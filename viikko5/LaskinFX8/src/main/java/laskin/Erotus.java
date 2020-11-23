package laskin;

public class Erotus extends LaskuOperaatio {

    public Erotus(IO io, ISovelluslogiikka logiikka) {
        super(io, logiikka);
    }

    @Override
    public int laske(int arvo) {
        this.logiikka.miinus(arvo);
        return this.logiikka.tulos();
    }

    @Override
    public void peru() {
    }


}
