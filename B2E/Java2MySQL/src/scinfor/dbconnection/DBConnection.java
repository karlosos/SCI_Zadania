package scinfor.dbconnection;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import scinfor.databaseconfig.DataBaseConnectionData;

/**
 *
 * @author Jacek
 * Klasa reprezentuje mechanizm połączenia
 * z bazą danych
 */
public class DBConnection {

    /**
     * konstruktor
     */
    public DBConnection() {
        dbConnectionData = new DataBaseConnectionData();
        connectionState = false;
    }
    
    public boolean  getConnectionState() {
        return connectionState;
    }
    
    public void ConnectAlfa() throws SQLException
    {
        //dbConnectionData.setHostName("localhost");
        //dbConnectionData.setDatabaseName("scinfor");
        //dbConnectionData.setUser("root");
        //dbConnectionData.setPassword("");
            String connURL =
                    dbConnectionData.getUrlProtokolName() + 
                    dbConnectionData.getHostName()+ "/"+
                    dbConnectionData.getDatabaseName();
    
            try {
                Class.forName(dbConnectionData.getClassDriveName());
                myConnection=DriverManager.getConnection(connURL, dbConnectionData.getUser(),dbConnectionData.getPassword());        
                System.out.println("Message from class: Connected OK...");
            }
    

            catch (ClassNotFoundException e) {
                System.out.println("Bad connected...");
                System.out.println("Nie mozna zaladowac sterownika");
                throw new SQLException(e.toString());
            }
    }

    public DataBaseConnectionData getDbConnectionData() {
        return dbConnectionData;
    }
    
    
    
    //metoda ustawia połączenie
    public void ConnectBeta() {
     
        dbConnectionData.setHostName("localhost");
        dbConnectionData.setDatabaseName("scitestdb");
        dbConnectionData.setUser("Jacek");
        dbConnectionData.setPassword("sci");
        String connURL =
                dbConnectionData.getUrlProtokolName() + 
                dbConnectionData.getHostName()+ "/"+
                dbConnectionData.getDatabaseName();
 
        try {
            Class.forName(dbConnectionData.getClassDriveName());
            try (Connection connection = DriverManager.getConnection(connURL, dbConnectionData.getUser(),dbConnectionData.getPassword());

                    Statement stmt = connection.createStatement()) {
                
                stmt.execute("select * from osoby"); // execute query in table osoby
                //ResultSet rs = stmt.getResultSet(); // get any Result that came from our query
                //if (rs != null)
                    //while ( rs.next() ){
                    // System.out.println
                    //    (
                    //            "ID: " + rs.getString("id_osoba") + " "+
                    //            rs.getString("imie")+" "+
                    //            rs.getString("nazwisko")
                    //    );
                    //}
            }
            connectionState = true;
        }
        catch (ClassNotFoundException | SQLException err) {
            System.out.println("ERROR: " + err);
            connectionState = false;
        }
    }
    
    DataBaseConnectionData dbConnectionData;//dane dla zestawienie połączenia
    boolean connectionState;//flaga stanu połączenia
    Connection myConnection;
}
