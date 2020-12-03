package ohtu.kps.logiikka;

import com.google.common.collect.EvictingQueue;
import static ohtu.kps.vakiot.Vakiot.*;

/**
 * Vaikeampi tekoäly joka muistaa vastustajan siirrot.
 */
public class TekoalyParannettu implements ITekoaly {

    private EvictingQueue<String> muisti;

    public TekoalyParannettu(int muistinKoko) {
        muisti = EvictingQueue.create(muistinKoko);
    }

    @Override
    public void asetaSiirto(String siirto) {
        if (!(siirto.equals(KIVI) || siirto.equals(SAKSET)|| siirto.equals(PAPERI))) {
            throw new IllegalArgumentException("Siirto ei sallitussa muodossa! Sallittuja 'k', 'p' ja 's'");
        }
        muisti.add(siirto);
    }

    @Override
    public String annaSiirto() {

        String[] siirrot = muisti.toArray(new String[muisti.size()]);

        String viimeisinVastustajanSiirto = siirrot[muisti.size() - 1];

        if (viimeisinVastustajanSiirto == null) {
            return KIVI;
        }

        int kivia = 0;
        int papereita = 0;
        int saksia = 0;

        for (String siirto : siirrot) {

            switch (siirto) {
                case KIVI:
                    kivia++;
                    break;
                case PAPERI:
                    papereita++;
                    break;
                case SAKSET:
                    saksia++;
                    break;
                default:
                    break;
            }
        }

        if (kivia > papereita && kivia > saksia) {
            return PAPERI;
        } else if (papereita > kivia && papereita > saksia) {
            return SAKSET;
        } else {
            return KIVI;
        }

    }
}
