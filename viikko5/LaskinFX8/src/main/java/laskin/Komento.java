package laskin;

public abstract class Komento {

    protected IO io;
    protected ISovelluslogiikka logiikka;

    public Komento(IO io, ISovelluslogiikka logiikka) {
        this.io = io;
        this.logiikka = logiikka;
    }

    public abstract void suorita();

    public abstract void peru();

}
