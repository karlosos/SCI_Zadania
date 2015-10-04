/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.kik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Karol
 */
public class Gra {

    private int[][] plansza;
    private int ostatniRuch;
    private Gracz ktoWygral;

    private boolean graZAI;
    private String wiadomosc;

    private Gracz gracz1;
    private Gracz gracz2;
    private AI graczAI;

    private ArrayList<ArrayList<ArrayList<Integer>>> liniePlanszy;

    private boolean czyAktywna = false; // czy gra jest aktywna

    final public String znak0 = " ";
    final public String znak1 = "O";
    final public String znak2 = "X";

    public Gra(String imieGracza1, String imieGracza2, int symbolGracza1, int symbolGracza2) {
        this.plansza = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plansza[i][j] = 0;
            }
        }
        liniePlanszy();
        gracz1 = new Gracz(imieGracza1, symbolGracza1);
        gracz2 = new Gracz(imieGracza2, symbolGracza2);

        this.ostatniRuch = 0;
        czyAktywna = true;
        this.graZAI = false;
    }

    public Gra(String imieGracza1, int symbolGracza1, int symbolGraczaAI) {
        this.plansza = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plansza[i][j] = 0;
            }
        }
        liniePlanszy();
        gracz1 = new Gracz(imieGracza1, symbolGracza1);
        graczAI = new AI(symbolGraczaAI, liniePlanszy);
        gracz2 = graczAI;

        this.ostatniRuch = 0;
        czyAktywna = true;
        this.graZAI = true;

        // Losuje czy ma zaczynać AI czy gracz
//        Random r = new Random();
//        int los = r.nextInt(2);
//        if (los == 1) {
//            ruchAI();
//        }
        
        // Jeżeli AI jest kółkiem to zaczyna
//        if (graczAI.getFigura() == 1) {
//            ruchAI();
//        }
        
        System.out.println("Nowa gra");
    }

    public void ruch(int wiersz, int kolumna) {
        if (czyAktywna && plansza[wiersz][kolumna] == 0) {
            if (this.plansza[wiersz][kolumna] == 0) {
                if (ostatniRuch == 0) {
                    this.plansza[wiersz][kolumna] = gracz1.getFigura();
                    ostatniRuch = gracz1.getFigura();
                } else if (ostatniRuch == 2) {
                    this.plansza[wiersz][kolumna] = 1;
                    ostatniRuch = 1;
                } else if (ostatniRuch == 1) {
                    this.plansza[wiersz][kolumna] = 2;
                    ostatniRuch = 2;
                }
            }
            sprawdzStan();

            if (czyAktywna && graZAI) {
                ruchAI();
            }
        }
    }

    private void ruchAI() {
        int[] ruchAI = graczAI.ruch(plansza);
        int x = ruchAI[0];
        int y = ruchAI[1];
        plansza[x][y] = graczAI.getFigura();
        ostatniRuch = graczAI.getFigura();
        sprawdzStan();
    }

    private boolean sprawdzStan() {
        for (int i = 0; i < 8; i++) {
            ArrayList<Integer> wartosci = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                wartosci.add(plansza[liniePlanszy.get(i).get(j).get(0)][liniePlanszy.get(i).get(j).get(1)]);
            }

            Collections.sort(wartosci);

            if (Objects.equals(wartosci.get(0), wartosci.get(2)) && wartosci.get(0) != 0) {
                czyAktywna = false;
                sprawdzKtoWygral(wartosci.get(0));
                return false;
            }
        }

        int suma = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (plansza[i][j] > 0) {
                    suma++;
                }
            }

        }

        if (suma >= 9) {
            czyAktywna = false;
            sprawdzKtoWygral(0);
            return false;
        }
        return true;
    }

    private void sprawdzKtoWygral(int symbolWygranego) {
        if (gracz1.getFigura() == symbolWygranego) {
            ktoWygral = gracz1;
            wiadomosc = "Wygrał " + gracz1.getImie() + ".";
        } else if (gracz2.getFigura() == symbolWygranego) {
            ktoWygral = gracz2;
            wiadomosc = "Wygrał " + gracz2.getImie() + ".";
        } else {
            wiadomosc = "Gra nierostrzygnięta";
        }
    }

    public int getZnakNaPozycji(int wiersz, int kolumna) {
        int znak = 0;
        znak = plansza[wiersz][kolumna];
        return znak;
    }

    public boolean czyAktywna() {
        return czyAktywna;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }

    private void liniePlanszy() {
        int[][] planszaDoRuchow = new int[9][2];

        planszaDoRuchow[0][0] = 0;
        planszaDoRuchow[0][1] = 0;

        planszaDoRuchow[1][0] = 0;
        planszaDoRuchow[1][1] = 1;

        planszaDoRuchow[2][0] = 0;
        planszaDoRuchow[2][1] = 2;

        planszaDoRuchow[3][0] = 1;
        planszaDoRuchow[3][1] = 0;

        planszaDoRuchow[4][0] = 1;
        planszaDoRuchow[4][1] = 1;

        planszaDoRuchow[5][0] = 1;
        planszaDoRuchow[5][1] = 2;

        planszaDoRuchow[6][0] = 2;
        planszaDoRuchow[6][1] = 0;

        planszaDoRuchow[7][0] = 2;
        planszaDoRuchow[7][1] = 1;

        planszaDoRuchow[8][0] = 2;
        planszaDoRuchow[8][1] = 2;

        int[][] linieNaPlanszy = new int[8][3];
        linieNaPlanszy[0][0] = 0;
        linieNaPlanszy[0][1] = 1;
        linieNaPlanszy[0][2] = 2;

        linieNaPlanszy[1][0] = 3;
        linieNaPlanszy[1][1] = 4;
        linieNaPlanszy[1][2] = 5;

        linieNaPlanszy[2][0] = 6;
        linieNaPlanszy[2][1] = 7;
        linieNaPlanszy[2][2] = 8;

        linieNaPlanszy[3][0] = 0;
        linieNaPlanszy[3][1] = 3;
        linieNaPlanszy[3][2] = 6;

        linieNaPlanszy[4][0] = 1;
        linieNaPlanszy[4][1] = 4;
        linieNaPlanszy[4][2] = 7;

        linieNaPlanszy[5][0] = 2;
        linieNaPlanszy[5][1] = 5;
        linieNaPlanszy[5][2] = 8;

        linieNaPlanszy[6][0] = 6;
        linieNaPlanszy[6][1] = 4;
        linieNaPlanszy[6][2] = 2;

        linieNaPlanszy[7][0] = 0;
        linieNaPlanszy[7][1] = 4;
        linieNaPlanszy[7][2] = 8;

        liniePlanszy = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ArrayList<ArrayList<Integer>> linia = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                ArrayList linia_wspolrzedne = new ArrayList<>();
                linia_wspolrzedne.add(planszaDoRuchow[linieNaPlanszy[i][j]][0]);
                linia_wspolrzedne.add(planszaDoRuchow[linieNaPlanszy[i][j]][1]);
                linia.add(linia_wspolrzedne);
            }
            liniePlanszy.add(linia);
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("Linia " + i);
            for (int j = 0; j < 3; j++) {
                System.out.println("Komórka " + j);
                for (int k = 0; k < 2; k++) {
                    System.out.print(liniePlanszy.get(i).get(j).get(k));
                }
                System.out.print("\n");
            }
        }
    }
}
