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

    private int[][] plansza;

    public AI(int figura) {
        super("komputer", figura);
    }

    public int[] ruch(int[][] plansza) {
        this.plansza = plansza;
        int[] ruch = new int[2];
        ruch = wygranyRuch();
        return ruch;
    }

    private int[] wygranyRuch() {
        int[] ruch = new int[2];

        // po przekatnej
        // 00, 11, 22
        ArrayList<Integer> wiersze = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            if(plansza[i][i] == 0) {
                ruch[0] = i;
                ruch[1] = i;
            }
            wiersze.add(plansza[i][i]);
        }
        Collections.sort(wiersze);
        wiersze.get(0); // puste
        wiersze.get(1); // nasze pole
        wiersze.get(2); // nasze pole

        if (wiersze.get(0) == 0 && wiersze.get(1).equals(wiersze.get(2)) && wiersze.get(1) > 0) {
            System.out.println(wiersze.get(0) + " " + wiersze.get(1) + " " + wiersze.get(2));
            return ruch;
        }
        
        // po przekatnej
        // 20, 11, 10
        wiersze = new ArrayList<Integer>();
        
        wiersze.add(plansza[2][0]);
        wiersze.add(plansza[1][1]);
        wiersze.add(plansza[1][0]);
        
        if(plansza[2][0] == 0) {
            ruch[0] = 2;
            ruch[1] = 0;
        }
        
        if(plansza[1][1] == 0) {
            ruch[0] = 2;
            ruch[1] = 0;
        }
        
        if(plansza[1][0] == 0) {
            ruch[0] = 2;
            ruch[1] = 0;
        }
        
        Collections.sort(wiersze);
        wiersze.get(0); // puste
        wiersze.get(1); // nasze pole
        wiersze.get(2); // nasze pole

       if (wiersze.get(0) == 0 && wiersze.get(1).equals(wiersze.get(2)) && wiersze.get(1) > 0) {
            System.out.println(wiersze.get(0) + " " + wiersze.get(1) + " " + wiersze.get(2));
            return ruch;
        }
        
        // w rzedzie
        // 00, 01, 02
        wiersze = new ArrayList<Integer>();
        
        for (int i = 0; i < 3; i++) {
            if(plansza[0][i] == 0) {
                ruch[0] = 0;
                ruch[1] = i;
            }
            wiersze.add(plansza[0][i]);
        }

       if (wiersze.get(0) == 0 && wiersze.get(1).equals(wiersze.get(2)) && wiersze.get(1) > 0) {
            System.out.println(wiersze.get(0) + " " + wiersze.get(1) + " " + wiersze.get(2));
            return ruch;
        }
        
        // w rzedzie
        // 10, 11, 12
        wiersze = new ArrayList<Integer>();
        
        for (int i = 0; i < 3; i++) {
            if(plansza[1][i] == 0) {
                ruch[0] = 1;
                ruch[1] = i;
            }
            wiersze.add(plansza[1][i]);
        }

        if (wiersze.get(0) == 0 && wiersze.get(1).equals(wiersze.get(2)) && wiersze.get(1) > 0) {
            System.out.println(wiersze.get(0) + " " + wiersze.get(1) + " " + wiersze.get(2));
            return ruch;
        }
        
        // w rzedzie
        // 20, 21, 22
        wiersze = new ArrayList<Integer>();
        
        for (int i = 0; i < 3; i++) {
            if(plansza[2][i] == 0) {
                ruch[0] = 2;
                ruch[1] = i;
            }
            wiersze.add(plansza[2][i]);
        }

       if (wiersze.get(0) == 0 && wiersze.get(1).equals(wiersze.get(2)) && wiersze.get(1) > 0) {
            System.out.println(wiersze.get(0) + " " + wiersze.get(1) + " " + wiersze.get(2));
            return ruch;
        }
       
        // w rzedzie
        // 00, 10, 20
        wiersze = new ArrayList<Integer>();
        
        for (int i = 0; i < 3; i++) {
            if(plansza[i][0] == 0) {
                ruch[0] = i;
                ruch[1] = 0;
            }
            wiersze.add(plansza[i][0]);
        }

       if (wiersze.get(0) == 0 && wiersze.get(1).equals(wiersze.get(2)) && wiersze.get(1) > 0) {
            System.out.println(wiersze.get(0) + " " + wiersze.get(1) + " " + wiersze.get(2));
            return ruch;
        }
       
       // w rzedzie
        // 01, 11, 21
        wiersze = new ArrayList<Integer>();
        
        for (int i = 0; i < 3; i++) {
            if(plansza[i][0] == 0) {
                ruch[0] = i;
                ruch[1] = 1;
            }
            wiersze.add(plansza[i][1]);
        }

       if (wiersze.get(0) == 0 && wiersze.get(1).equals(wiersze.get(2)) && wiersze.get(1) > 0) {
            System.out.println(wiersze.get(0) + " " + wiersze.get(1) + " " + wiersze.get(2));
            return ruch;
        }
       
       // w rzedzie
        // 02, 12, 22
        wiersze = new ArrayList<Integer>();
        
        for (int i = 0; i < 3; i++) {
            if(plansza[i][2] == 0) {
                ruch[0] = i;
                ruch[1] = 2;
            }
            wiersze.add(plansza[i][2]);
        }

       if (wiersze.get(0) == 0 && wiersze.get(1).equals(wiersze.get(2)) && wiersze.get(1) > 0) {
            System.out.println(wiersze.get(0) + " " + wiersze.get(1) + " " + wiersze.get(2));
            return ruch;
        }

        // teraz znajdzmy wolne
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
        
        ruch[0] = wolne.get(r.nextInt(wolne.size())).get(0);
        ruch[1] = wolne.get(r.nextInt(wolne.size())).get(1);
        System.out.println(ruch[0] + " " + ruch[1]);
        
        return ruch;
    }
}
