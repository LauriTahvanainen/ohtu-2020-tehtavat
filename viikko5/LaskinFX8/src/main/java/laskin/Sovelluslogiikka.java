package laskin;

public class Sovelluslogiikka implements ISovelluslogiikka {
 
    private int tulos;
    private int edellinenTulos;
 
    @Override
    public void plus(int luku) {
        this.edellinenTulos = this.tulos;
        tulos += luku;
    }
     
    @Override
    public void miinus(int luku) {
        this.edellinenTulos = this.tulos;
        tulos -= luku;
    }
 
    @Override
    public void nollaa() {
        this.edellinenTulos = this.tulos;
        tulos = 0;
    }
 
    @Override
    public int tulos() {
        return tulos;
    }

    @Override
    public void peru() {
        this.tulos = this.edellinenTulos;
    }
}