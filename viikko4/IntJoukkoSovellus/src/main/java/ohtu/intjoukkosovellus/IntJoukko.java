package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5; // aloitustaulukon oletuskoko
    public final static int OLETUSKASVATUS = 5;  // luotava uusi taulukko on oletuksena
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm; 

    public IntJoukko() {
        taulukko = new int[KAPASITEETTI];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Kapasiteetin on oltava positiivinen! Annettiin : " + kapasiteetti);
        }
        taulukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Kapasiteetin on oltava positiivinen! Annettiin : " + kapasiteetti);
        }
        if (kasvatuskoko < 0) {
            throw new IllegalArgumentException("Kasvatuskoon on oltava positiivinen! Annettiin : " + kasvatuskoko);
        }
        taulukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        taulukko[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm == taulukko.length) {
            kasvataTaulukkoa();
        }
        return true;

    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int lukuIndeksissa = -1;
        // Luvun löytäminen
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == this.taulukko[i]) {
                lukuIndeksissa = i;
            }
        }

        if (lukuIndeksissa != -1) {
            // edellä olevien lukujen siirtäminen
            for (int i = lukuIndeksissa; i < alkioidenLkm; i++) {
                // Voidaan tehdä aina turvallisesti, sillä taulukko on aina pidempi kuin alkioidenlkm.
                this.taulukko[i] = this.taulukko[i + 1];
            }
            this.alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void kasvataTaulukkoa() {
        int[] uusiTaulukko = new int[this.alkioidenLkm + this.kasvatuskoko];
        System.arraycopy(this.taulukko, 0, uusiTaulukko, 0, this.alkioidenLkm);
        this.taulukko = uusiTaulukko;
    }

    public int koko() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (this.alkioidenLkm == 0) {
            return "{}";
        }

        String palautettava = "{";
        for (int i = 0; i < this.alkioidenLkm; i++) {
            palautettava += this.taulukko[i] + ", ";
        }
        return palautettava.substring(0, palautettava.length() - 2) + "}";
    }

    public int[] toIntArray() {
        int[] palautettava = new int[alkioidenLkm];
        System.arraycopy(taulukko, 0, palautettava, 0, palautettava.length);
        return palautettava;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] aTaulukko = a.toIntArray();
        int[] bTaulukko = b.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            yhdisteJoukko.lisaa(aTaulukko[i]);
        }
        for (int i = 0; i < bTaulukko.length; i++) {
            yhdisteJoukko.lisaa(bTaulukko[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulukko = a.toIntArray();
        int[] bTaulukko = b.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            for (int j = 0; j < bTaulukko.length; j++) {
                if (aTaulukko[i] == bTaulukko[j]) {
                    leikkausJoukko.lisaa(bTaulukko[j]);
                }
            }
        }
        return leikkausJoukko;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulukko = a.toIntArray();
        int[] bTaulukko = b.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            erotusJoukko.lisaa(aTaulukko[i]);
        }
        for (int i = 0; i < bTaulukko.length; i++) {
            erotusJoukko.poista(bTaulukko[i]);
        }

        return erotusJoukko;
    }

}
