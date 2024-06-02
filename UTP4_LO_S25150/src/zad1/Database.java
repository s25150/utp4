package zad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    String driverName = "com.mysql.jdbc.Driver";
    //String url = "jdbc:mysql://localhost/ksidb";
    String url;
    String uid = "root";
    String pwd = "1qazXSW@";
    Connection con;
    TravelData travelData;

    public Database(String url, TravelData td) {
        this.url = url;
        travelData = td;

    }

    public void create() {
        String createStatement = "DROP TABLE IF EXISTS UTP4.Travel;\n" +
                "CREATE TABLE UTP4.Travel (\n" +
                "\tLokalizacja varchar(100) NULL,\n" +
                "\tKraj varchar(100) NULL,\n" +
                "\tData_wyjazdu DATE NULL,\n" +
                "\tData_powrotu DATE NULL,\n" +
                "\tMiejsce varchar(100) NULL,\n" +
                "\tCena FLOAT NULL,\n" +
                "\tSymbol_waluty varchar(100) NULL\n" +
                ");";
        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url, uid, pwd);
            Statement statement = con.createStatement();
            statement.executeUpdate(createStatement);
            //statement.close();
            //con.close();
        } catch (ClassNotFoundException  exc)  {  // brak klasy sterownika
            System.out.println("Brak klasy sterownika");
            System.out.println(exc);
            System.exit(1);
        } catch(SQLException exce) {  // nieudane połączenie
            System.out.println("Nieudane połączenie z " + url);
            System.out.println(exce);
            System.exit(1);
        }
    }

    public void showGui() {
    }
}
