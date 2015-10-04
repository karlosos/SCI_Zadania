package sci.pkn;

import java.util.Random;

public class Gra {
    // Zmienne klasy finalne piszemy wielkimi literami
    public static final String PAPIER = "Papier";
    public static final String KAMIEN = "Kamien";
    public static final String NOZYCE = "Nozyce";
    public static final String ZAWODNIK = "Zawodnik";
    public static final String KOMPUTER = "Komputer";
    public static final String REMIS = "Remis";
    
    int punktyZawodnika;
    int punktyKomputera;
    
    String ruchZawodnika;
    String ruchKomputera;
    
    
    int liczbaRund;
    int liczbaPozostalychRund;
    
    Random generator = new Random();
    
    boolean czyAktywna;
    
    String imieZawodnika;
    
    int statystykiGracza[];
    int statystykiKomputera[];

    public Gra(int ileRund, String imieZawodnika) {
        statystykiGracza = new int[3];
        statystykiKomputera = new int[3];
        
        czyAktywna = true;
        
        this.imieZawodnika = imieZawodnika;
        liczbaRund = ileRund;
        liczbaPozostalychRund = ileRund;
        
        punktyZawodnika = 0;
        punktyKomputera = 0;
        
        zerujStatystyki();
    }
    
    public void rozegrajRunde(String ruchZawodnika) {
        this.ruchZawodnika = ruchZawodnika;
        this.ruchKomputera = losujRuchKomputera();
        
        String zwyciezca = sprawdzZwyciezceRundy();
        
        switch (zwyciezca) {
            case ZAWODNIK : punktyZawodnika++; break;
            case KOMPUTER : punktyKomputera++; break;
        }
        
        zarzadcaStatystykami();
        zarzadcaLiczbamiRund();
        
        // TODO if liczba pozostalychrund <= 0 to zakoncz gre

    }
    
    private String losujRuchKomputera() {
        int los = generator.nextInt(3);
        
        switch (los) {
            case 0 : return PAPIER;
            case 1 : return NOZYCE;
            default : return KAMIEN;
        }
    }
    
    private String sprawdzZwyciezceRundy() {
        if(ruchZawodnika.equals(PAPIER)) {
            if(ruchKomputera.equals(KAMIEN))
                return ZAWODNIK;
            if(ruchKomputera.equals(NOZYCE))
                return KOMPUTER;
        }
        
        else if(ruchZawodnika.equals(KAMIEN)) {
            if(ruchKomputera.equals(NOZYCE))
                return ZAWODNIK;
            if(ruchKomputera.equals(PAPIER))
                return KOMPUTER;  
        }
        
        else if(ruchZawodnika.equals(NOZYCE)) {
            if(ruchKomputera.equals(PAPIER))
                return ZAWODNIK;
            if(ruchKomputera.equals(KAMIEN))
                return KOMPUTER;  
        }
        
        return REMIS;
    }
    
    private void zarzadcaLiczbamiRund() {
        liczbaPozostalychRund--;
        
        if(liczbaPozostalychRund <= 0) {
            czyAktywna = false;
        }
    }
    
    public String podsumowanieGry() {
        String podsumowanieGry;
        if(punktyZawodnika > punktyKomputera)
            podsumowanieGry = "Wygrał " + imieZawodnika + " " + punktyZawodnika + "-" + punktyKomputera;
        else if(punktyZawodnika < punktyKomputera)
            podsumowanieGry = "Wygrał komputer " + punktyKomputera + "-" + punktyZawodnika;
        else 
            podsumowanieGry = "Remis. " + punktyKomputera + "-" + punktyZawodnika;
    
        return podsumowanieGry;
    }
    
    private void zerujStatystyki() {
        for(int i=0; i<3; i++) {
            statystykiGracza[i] = 0;
            statystykiKomputera[i] = 0;
        }       
    }
    
    private void zarzadcaStatystykami() {
        if (ruchZawodnika.equals(PAPIER))
            statystykiGracza[0]++;
        else if (ruchZawodnika.equals(KAMIEN))
            statystykiGracza[1]++;
        else if (ruchZawodnika.equals(NOZYCE))
            statystykiGracza[2]++;
        
        if (ruchKomputera.equals(PAPIER))
            statystykiKomputera[0]++;
        else if (ruchKomputera.equals(KAMIEN))
            statystykiKomputera[1]++;
        else if (ruchKomputera.equals(NOZYCE))
            statystykiKomputera[2]++;
    }
}
