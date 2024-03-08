import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "mahalo");

            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
