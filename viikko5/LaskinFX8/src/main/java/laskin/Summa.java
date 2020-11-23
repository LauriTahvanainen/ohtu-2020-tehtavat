package laskin;

public class Summa extends LaskuOperaatio {

    public Summa(IO io, ISovelluslogiikka logiikka) {
        super(io, logiikka);
    }

    @Override
    public int laske(int arvo) {
        this.logiikka.plus(arvo);
        return this.logiikka.tulos();
    }

    @Override
    public void peru() {
    }

}
