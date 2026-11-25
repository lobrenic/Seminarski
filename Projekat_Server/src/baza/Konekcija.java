/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lazar
 */
public class Konekcija {
    private static Konekcija instance;
    private Connection connection;
    private static String database;
    private static String user;
    private static String pass;
    private Konekcija(){
        try {
            reconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Konekcija getInstance(){
        if(instance==null){
            instance=new Konekcija();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
    public void reconnect() throws SQLException, IOException{
        
        if(connection!=null && !connection.isClosed()){
            connection.close();
        }
        Properties props=new Properties();
        FileInputStream in = new FileInputStream(
        System.getProperty("user.dir") + "/src/baza/config.properties");
        props.load(in);
        database = props.getProperty("database");
        user = props.getProperty("user");
        pass = props.getProperty("password");
        String url = "jdbc:mysql://localhost:3306/" + database;
        
        connection = DriverManager.getConnection(url, user, pass);
        connection.setAutoCommit(false);
    }
}
