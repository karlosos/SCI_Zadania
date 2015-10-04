
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karol
 */
public class Gra {
    private boolean stan;
    private int przedzial;
    private int rundyDoKonca;
    
    private int liczbaDoZgadniecia;
    private int liczbaGracza;

    public Gra(int przedzial) {
        this.przedzial = przedzial;
        this.liczbaDoZgadniecia = liczbaDoZgadniecia(przedzial);
        rundyDoKonca = liczRundyDoKonca(przedzial);
        
        this.stan = true;
        
        System.out.println("Przedzial: " + this.przedzial + " Liczba do zgadniecia: " + this.liczbaDoZgadniecia);
    }
    
    public String Runda(int liczbaGracza) {
        System.out.println("Podales liczbe:" + liczbaGracza + " a zostalo ci rund: " + this.rundyDoKonca);
        
        this.liczbaGracza = liczbaGracza;
        rundyDoKonca--;
        if(rundyDoKonca < 0)
            stan = false;
        
        
        if(stan) {
            // tutaj sprawdzam i zrwacam tekst
            if(this.liczbaGracza > liczbaDoZgadniecia) {
                return "Liczba " + this.liczbaGracza + " jest za wielka \n";
            }
            else if (this.liczbaGracza < liczbaDoZgadniecia) {
                return "Liczba " + this.liczbaGracza + " jest za mala \n";
            }
            else if (this.liczbaGracza == liczbaDoZgadniecia) {
                this.stan = false;
                return "Brawo! Zgadles! Tajemnicza liczba to " + liczbaDoZgadniecia + "\n";
            }     
        }
        else {
            return "Nie mozesz grac, bo jest koniec gry. Rozpocznij gre jeszcze raz. \n";
        }
        
        return "B?ad \n";
    }

    private int liczbaDoZgadniecia(int przedzial) {
        Random generator = new Random();
        return generator.nextInt(przedzial);
    }
    
    private int liczRundyDoKonca(int przedzial) {
        if(przedzial == 100) 
            return 7;
        else if(przedzial == 1000)
            return 10;
        else {
            //wyjebany w chuj algorytm xd
            return 10;
        }
    }

    public boolean isStan() {
        return stan;
    }

    public int getRundyDoKonca() {
        return rundyDoKonca;
    }
 
}
