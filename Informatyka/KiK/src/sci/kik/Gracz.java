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
public class Gracz {
    private String imie;
    private int figura;

    public Gracz(String imie, int figura) {
        this.imie = imie;
        this.figura = figura;
    }
    
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getFigura() {
        return figura;
    }

    public void setFigura(int figura) {
        this.figura = figura;
    } 
}
