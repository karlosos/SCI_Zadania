/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.kik;

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

    private boolean czyAktywna = false; // czy gra jest aktywna

    final public String znak0 = " ";
    final public String znak1 = "X";
    final public String znak2 = "O";

    public Gra(String imieGracza1, String imieGracza2, int symbolGracza1, int symbolGracza2) {
        this.plansza = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plansza[i][j] = 0;
            }
        }

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

        gracz1 = new Gracz(imieGracza1, symbolGracza1);
        graczAI = new AI(symbolGraczaAI);
        gracz2 = graczAI;

        this.ostatniRuch = 0;
        czyAktywna = true;
        this.graZAI = true;
        
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
            
            if(graZAI) {
                int x = graczAI.ruch(plansza)[0];
                int y = graczAI.ruch(plansza)[1];
                plansza[x][y] = graczAI.getFigura();
                ostatniRuch = graczAI.getFigura();
                sprawdzStan();
            }
        }
    }

    private boolean sprawdzStan() {
        int suma = 0;
        for (int i = 0; i < 3; i++) {
            if ((plansza[i][0] == plansza[i][1]) && (plansza[i][0] == plansza[i][2]) && (plansza[i][1] == plansza[i][2]) && (plansza[i][0] != 0)) {
                czyAktywna = false;
                sprawdzKtoWygral(plansza[i][0]);
                return false;
            }
            if ((plansza[0][i] == plansza[1][i]) && (plansza[0][i] == plansza[2][i]) && (plansza[1][i] == plansza[2][i]) && (plansza[0][i] != 0)) {
                czyAktywna = false;
                sprawdzKtoWygral(plansza[0][i]);
                return false;
            }
            if ((plansza[0][0] == plansza[1][1]) && (plansza[0][0] == plansza[2][2]) && (plansza[1][1] == plansza[2][2]) && (plansza[1][1] != 0)) {
                czyAktywna = false;
                sprawdzKtoWygral(plansza[0][0]);
                return false;
            }
            if ((plansza[0][2] == plansza[1][1]) && (plansza[0][2] == plansza[2][0]) && (plansza[1][1] == plansza[2][0]) && (plansza[1][1] != 0)) {
                sprawdzKtoWygral(plansza[0][2]);
                czyAktywna = false;
                return false;
            }
            for (int j = 0; j < 3; j++) {
                if (plansza[i][j] > 0) {
                    suma++;
                }
            }

            if (suma >= 9) {
                czyAktywna = false;
                sprawdzKtoWygral(0);
                return false;
            }
        }
    return true;
    }

    private void sprawdzKtoWygral(int symbolWygranego) {
        if(gracz1.getFigura() == symbolWygranego) {
            ktoWygral = gracz1;
            wiadomosc = "Wygrał " + gracz1.getImie() + ".";
        }
        else if(gracz2.getFigura() == symbolWygranego) {
            ktoWygral = gracz2;
            wiadomosc = "Wygrał " + gracz2.getImie() + ".";
    }
        else {
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
    
    
}
