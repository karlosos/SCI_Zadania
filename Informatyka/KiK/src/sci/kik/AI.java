/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.kik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Karol
 */
public class AI extends Gracz {

    ArrayList<ArrayList<ArrayList<Integer>>>liniePlanszy;
    private int[][] plansza;

    public AI(int figura) {
        super("komputer", figura);
        liniePlanszy();
    }

    public int[] ruch(int[][] plansza) {
        this.plansza = plansza;
        int[] ruch = new int[2];
        ruch = wygranyRuch();
        if(ruch[0] == -1) {
            ruch = broniacyRuch();
        }
        if(ruch[0] == -1) {
            ruch = losujRuch();
        }
        return ruch;
    }

    private int[] wygranyRuch() {
        int[] ruch = new int[2];
        ruch[0] = -1;
        ruch[1] = -1;
   
        for (int i = 0; i < 8; i++) {
            ArrayList<Integer>wartosci = new ArrayList<Integer>();
            wartosci.add(plansza[liniePlanszy.get(i).get(0).get(0)][liniePlanszy.get(i).get(0).get(1)]);
            wartosci.add(plansza[liniePlanszy.get(i).get(1).get(0)][liniePlanszy.get(i).get(1).get(1)]);
            wartosci.add(plansza[liniePlanszy.get(i).get(2).get(0)][liniePlanszy.get(i).get(2).get(1)]);
            
            Collections.sort(wartosci);
            
            if(wartosci.get(0) == 0 && wartosci.get(1) == wartosci.get(2)) {
                if(wartosci.get(1) == super.getFigura()) {
                    for(int j = 0; j< 3; j++) {
                        if(plansza[liniePlanszy.get(i).get(j).get(0)][liniePlanszy.get(i).get(j).get(1)] == 0) {
                            ruch[0] = liniePlanszy.get(i).get(j).get(0);
                            ruch[1] = liniePlanszy.get(i).get(j).get(1);
                        }
                            
                    }
                }
            }
        }
        
        return ruch;
    }
    
       private int[] broniacyRuch() {
        int[] ruch = new int[2];
        ruch[0] = -1;
        ruch[1] = -1;
   
        for (int i = 0; i < 8; i++) {
            ArrayList<Integer>wartosci = new ArrayList<Integer>();
            wartosci.add(plansza[liniePlanszy.get(i).get(0).get(0)][liniePlanszy.get(i).get(0).get(1)]);
            wartosci.add(plansza[liniePlanszy.get(i).get(1).get(0)][liniePlanszy.get(i).get(1).get(1)]);
            wartosci.add(plansza[liniePlanszy.get(i).get(2).get(0)][liniePlanszy.get(i).get(2).get(1)]);
            
            Collections.sort(wartosci);
            
            if(wartosci.get(0) == 0 && wartosci.get(1) == wartosci.get(2)) {
                if(wartosci.get(1) != super.getFigura() && wartosci.get(1) != 0) {
                    for(int j = 0; j< 3; j++) {
                        if(plansza[liniePlanszy.get(i).get(j).get(0)][liniePlanszy.get(i).get(j).get(1)] == 0) {
                            ruch[0] = liniePlanszy.get(i).get(j).get(0);
                            ruch[1] = liniePlanszy.get(i).get(j).get(1);
                        }
                            
                    }
                }
            }
        }
        
        return ruch;
    }
    
    private int[] losujRuch() {
        int[] ruch = new int[2];
        ArrayList<ArrayList<Integer>>wolne = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(plansza[i][j] == 0) {
                    ArrayList wolne_wspolrzedne = new ArrayList<Integer>();
                    wolne_wspolrzedne.add(i);
                    wolne_wspolrzedne.add(j);
                    wolne.add(wolne_wspolrzedne);
                            }
            }
        }
        
        Random r = new Random();
        int los = r.nextInt(wolne.size());
        ruch[0] = wolne.get(los).get(0);
        ruch[1] = wolne.get(los).get(1);
        System.out.println(ruch[0] + " " + ruch[1]);
        
        return ruch;
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
        
        
        liniePlanszy = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0; i<8; i++) {
            ArrayList<ArrayList<Integer>>linia = new ArrayList<ArrayList<Integer>>();
            for(int j=0; j<3; j++) {
                ArrayList linia_wspolrzedne = new ArrayList<Integer>();
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
