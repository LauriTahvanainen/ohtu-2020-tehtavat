package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa sut;

    @Before
    public void SetUp() {
        // luodaan ensin mock-oliot
        pankki = mock(Pankki.class);

        viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        sut = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {

        // tehdään ostokset
        sut.aloitaAsiointi();
        sut.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        sut.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaAsiakkaanTiedoillaJaSummalla() {

        // tehdään ostokset
        sut.aloitaAsiointi();
        sut.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        sut.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(5));
    }

    @Test
    public void kahdenEriTuotteenOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaAsiakkaanTiedoillaJaSummalla() {
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "porkkana", 2));

        // tehdään ostokset
        sut.aloitaAsiointi();
        sut.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        sut.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli porkkana
        sut.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(7));
    }

    @Test
    public void kahdenSamanTuotteenOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaAsiakkaanTiedoillaJaSummalla() {

        // tehdään ostokset
        sut.aloitaAsiointi();
        sut.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        sut.lisaaKoriin(1);     // ostetaan tuotetta numero 2 eli porkkana
        sut.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(10));
    }

    @Test
    public void kahdenEriTuotteenJoistaToistaEiVarastossaOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaAsiakkaanTiedoillaJaSummalla() {
        // porkkanoiden saldo nollaan
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "porkkana", 2));

        // tehdään ostokset
        sut.aloitaAsiointi();
        sut.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        sut.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli porkkana
        sut.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(5));
    }
}
