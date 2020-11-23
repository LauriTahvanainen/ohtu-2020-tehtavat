package laskin;

public interface IO {

    void piilotaNollaus();

    void naytaNollaus();

    void naytaUndo();

    void piilotaUndo();

    public void paivitaNakyma(int laskunTulos);

    public int getSyote();

    public String haeSummaKomponentti();

    public String haeNollausKomponentti();

    public String haeErotusKomponentti();

    public String haeUndoKomponentti();

}
