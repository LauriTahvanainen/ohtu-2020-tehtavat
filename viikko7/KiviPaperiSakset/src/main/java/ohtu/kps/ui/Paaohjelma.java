package ohtu.kps.ui;

import java.util.Scanner;
import ohtu.kps.logiikka.KiviPaperiSakset;
import ohtu.kps.logiikka.PeliTehdas;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            KiviPaperiSakset peli;
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                peli = PeliTehdas.pelaajaVastaanPelaaja();
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                peli = PeliTehdas.pelaajaVastaanTekoaly();
            } else if (vastaus.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                peli = PeliTehdas.pelaajaVastaanTekoaly();
            } else {
                break;
            }
            peli.pelaa();

        }

    }
}
