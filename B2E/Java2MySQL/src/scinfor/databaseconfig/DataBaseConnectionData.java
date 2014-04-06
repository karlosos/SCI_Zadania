/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scinfor.databaseconfig;

/**
 *
 * @author SCI Jack Flower 2014-03-27
 * Klasa reprezentuje opkowanie danych
 * niezbędnych do nawiązania połączenia
 * z bazą danych mySql (XAMPP: Apache, MySql, PHPMyAdmin)
 */
public class DataBaseConnectionData {

    /**
     * Konstruktor
     */
    public DataBaseConnectionData() {
        //
        this.classDriveName = "com.mysql.jdbc.Driver";
        this.urlProtokolName = "jdbc:mysql://";
        this.hostName = "localhost";
        this.databaseName = null;
        this.user = null;
        this.password = null;
    }

    public String getClassDriveName() {
        return classDriveName;
    }

    public void setClassDriveName(String classDriveName) {
        this.classDriveName = classDriveName;
    }

    public String getUrlProtokolName() {
        return urlProtokolName;
    }

    public void setUrlProtokolName(String urlProtokolName) {
        this.urlProtokolName = urlProtokolName;
    }
    
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //pola klasy
    String classDriveName;  //driver              (np. "com.mysql.jdbc.Driver")
    String urlProtokolName; //protokół połączenia (np."jdbc:mysql://")
    String hostName;        //nazwa hosta         (np. "localhost")
    String databaseName;    //baza danych
    String user;            //użytkownik tego zasobu
    String password;        //hasło użytkownika
    //uwaga:
    //Impelmentowane rozwiązanie, zakłada, że będziemy korzystali
    //z serwera Apache oraz bazy danych mySql, co zostało uwzględnione
    //w kostruktorze, poprzez zdefiniowane tam stałe wartości.
}
