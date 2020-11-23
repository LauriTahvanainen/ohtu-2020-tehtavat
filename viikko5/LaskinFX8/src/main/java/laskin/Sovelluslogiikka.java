package laskin;

public class Sovelluslogiikka implements ISovelluslogiikka {
 
    private int tulos;
 
    @Override
    public void plus(int luku) {
        tulos += luku;
    }
     
    @Override
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    @Override
    public void nollaa() {
        tulos = 0;
    }
 
    @Override
    public int tulos() {
        return tulos;
    }
}