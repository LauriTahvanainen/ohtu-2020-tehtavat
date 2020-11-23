package laskin;

import java.util.HashMap;

public class GraafinenKomentoPalvelu {

    private HashMap<String, Komento> komennot;
    private Komento edellinen = null;
    private String undoKomponenttiID;
    private String nollaaKomponenttiID;

    public GraafinenKomentoPalvelu(IO io, ISovelluslogiikka logiikka) {
        this.undoKomponenttiID = io.haeUndoKomponentti();
        this.nollaaKomponenttiID = io.haeNollausKomponentti();
        this.komennot = new HashMap<>();
        this.komennot.put(io.haeErotusKomponentti(), new Erotus(io, logiikka));
        this.komennot.put(io.haeSummaKomponentti(), new Summa(io, logiikka));
        this.komennot.put(io.haeNollausKomponentti(), new Nollaa(io, logiikka));
        this.komennot.put(io.haeUndoKomponentti(), new Tuntematon(io, logiikka));

    }

    public void SuoritaKysyttyKomento(String komponenttiID) {
        Komento suoritettava = this.komennot.get(komponenttiID);
        if (!komponenttiID.equals(this.undoKomponenttiID)) {
            suoritettava.suorita();
            this.edellinen = suoritettava;
        } else if (this.edellinen != null) {
            this.edellinen.peru();
            this.edellinen = null;
        }
    }
}
