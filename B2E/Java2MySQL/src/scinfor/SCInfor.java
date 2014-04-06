/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scinfor;

//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import scinfor.dbconnection.DBConnection;
/**
 *
 * @author Jacek
 */
public class SCInfor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //tworzymy obiekt połączenia
        //DBConnection dbConnection = new DBConnection();
        //nawiązanie połączenia
        //try {
        //    dbConnection.ConnectAlfa();
        //} catch (SQLException ex) {
        //    Logger.getLogger(SCInfor.class.getName()).log(Level.SEVERE, null, ex);
        //}

        DBConnectJFrame okno = new DBConnectJFrame();
        okno.setVisible(true);
        
    }
    
}


        //2014-03-29  s t a r t
        //System.out.println(dbConnection.getConnectionState());
        //DataBaseConnectionData DBConnection = new DataBaseConnectionData();
        //te pola do formularza...
        //DBConnection.setHostName("localhost");
        //DBConnection.setDatabaseName("scitestdb");
        //DBConnection.setUser("Jacek");
        //DBConnection.setPassword("sci");
        //te pola do formularza...
        /*
        try {

            Class.forName(DBConnection.getClassDriveName());

            String connURL= DBConnection.getUrlProtokolName() + DBConnection.getHostName()+ "/"+ DBConnection.getDatabaseName();
            try (Connection con = DriverManager.getConnection(connURL, DBConnection.getUser(),DBConnection.getPassword()); 
                    Statement stmt = con.createStatement()) {
                stmt.execute("select * from osoby"); // execute query in table osoby
                ResultSet rs = stmt.getResultSet(); // get any Result that came from our query
                if (rs != null)
                    while ( rs.next() ){
                     System.out.println
                        (
                                "ID: " + rs.getString("id_osoba") + " "+
                                rs.getString("imie")+" "+
                                rs.getString("nazwisko")
                        );
                    }
            }
        }
        */
        //catch (ClassNotFoundException | SQLException err) {
        //    System.out.println("ERROR: " + err);
        //}
        //2014-03-29  s t o p
