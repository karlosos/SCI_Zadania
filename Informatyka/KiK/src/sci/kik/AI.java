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

    private ArrayList<ArrayList<ArrayList<Integer>>> liniePlanszy;
    private int[][] plansza;

    public AI(int figura, ArrayList<ArrayList<ArrayList<Integer>>> liniePlanszy) {
        super("komputer", figura);
        this.liniePlanszy = liniePlanszy;
    }

    public int[] ruch(int[][] plansza) {
        this.plansza = plansza;
        int[] ruch = new int[2];
        ruch = wygranyRuch();
        if (ruch[0] == -1) {
            ruch = broniacyRuch();
        }
        if (ruch[0] == -1) {
            ruch = losujRuch();
        }
        return ruch;
    }

    private int[] wygranyRuch() {
        int[] ruch = new int[2];
        ruch[0] = -1;
        ruch[1] = -1;

        for (int i = 0; i < 8; i++) {
            ArrayList<Integer> wartosci = new ArrayList<Integer>();
            wartosci.add(plansza[liniePlanszy.get(i).get(0).get(0)][liniePlanszy.get(i).get(0).get(1)]);
            wartosci.add(plansza[liniePlanszy.get(i).get(1).get(0)][liniePlanszy.get(i).get(1).get(1)]);
            wartosci.add(plansza[liniePlanszy.get(i).get(2).get(0)][liniePlanszy.get(i).get(2).get(1)]);

            Collections.sort(wartosci);

            if (wartosci.get(0) == 0 && wartosci.get(1) == wartosci.get(2)) {
                if (wartosci.get(1) == super.getFigura()) {
                    for (int j = 0; j < 3; j++) {
                        if (plansza[liniePlanszy.get(i).get(j).get(0)][liniePlanszy.get(i).get(j).get(1)] == 0) {
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
            ArrayList<Integer> wartosci = new ArrayList<Integer>();
            wartosci.add(plansza[liniePlanszy.get(i).get(0).get(0)][liniePlanszy.get(i).get(0).get(1)]);
            wartosci.add(plansza[liniePlanszy.get(i).get(1).get(0)][liniePlanszy.get(i).get(1).get(1)]);
            wartosci.add(plansza[liniePlanszy.get(i).get(2).get(0)][liniePlanszy.get(i).get(2).get(1)]);

            Collections.sort(wartosci);

            if (wartosci.get(0) == 0 && wartosci.get(1) == wartosci.get(2)) {
                if (wartosci.get(1) != super.getFigura() && wartosci.get(1) != 0) {
                    for (int j = 0; j < 3; j++) {
                        if (plansza[liniePlanszy.get(i).get(j).get(0)][liniePlanszy.get(i).get(j).get(1)] == 0) {
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
        ArrayList<ArrayList<Integer>> wolne = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (plansza[i][j] == 0) {
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
}
