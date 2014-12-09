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
    
    private boolean czyAktywna = false; // czy gra jest aktywna
    
    final public String znak0 = " ";
    final public String znak1 = "X";
    final public String znak2 = "O";
    
    

    public Gra() {
        this.plansza = new int[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                plansza[i][j] = 0;
            }
        }
        
        this.ostatniRuch = 0;
        czyAktywna = true;
    }
    
    public void ruch(int wiersz, int kolumna) {
        if(czyAktywna) {
            if(this.plansza[wiersz][kolumna] == 0) {
                if(ostatniRuch==0 || ostatniRuch==2) {
                    this.plansza[wiersz][kolumna] = 1;
                    ostatniRuch = 1;
                }
                else if(ostatniRuch==1) {
                    this.plansza[wiersz][kolumna] = 2;
                    ostatniRuch = 2;
                }
            }
            sprawdzStan();
        }
    }
    
    private void sprawdzStan() {
        for(int i=0; i<3; i++) {
            if((plansza[i][0] == plansza[i][1]) && (plansza[i][0] ==plansza[i][2]) && (plansza[i][1] == plansza[i][2]) && (plansza[i][0] != 0)) 
                czyAktywna = false;
            if((plansza[0][i] == plansza[1][i]) && (plansza[0][i] ==plansza[2][i]) && (plansza[1][i] == plansza[2][i]) && (plansza[0][i] != 0)) 
                czyAktywna = false;
            if((plansza[0][0] == plansza[1][1]) && (plansza[0][0] ==plansza[2][2]) && (plansza[1][1] == plansza[2][2]) && (plansza[1][1] != 0)) 
                czyAktywna = false;
            if((plansza[0][2] == plansza[1][1]) && (plansza[0][2] ==plansza[2][0]) && (plansza[1][1] == plansza[2][0]) && (plansza[1][1] != 0)) 
                czyAktywna = false;
        }
    }
    public int getZnakNaPozycji(int wiersz, int kolumna){
        int znak = 0;
        znak = plansza[wiersz][kolumna];
        return znak;
    }
    
    public boolean czyAktywna() {
        return czyAktywna;
    }
}
