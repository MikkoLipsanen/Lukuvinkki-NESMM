package lukuvinkki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


@SpringBootApplication
public class Application {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
        
//            Class.forName ("org.h2.Driver");

    // Enable logging
    // DriverManager.setLogStream(System.err);

//    String URL = "jdbc:h2:mem:example-app";
    
//    System.out.println("Getting Connection");
//    Connection c = DriverManager.getConnection (
//      "jdbc:h2:mem:example-app",
//      "ha", "");  // user, passwd
//    DatabaseMetaData md = c.getMetaData();
//    ResultSet rs = md.getTables(null, null, "%", null);
//    while (rs.next()) {
//      System.out.println(rs.getString(3));
//    }
//    }
    
//    Connection conn = DriverManager.getConnection(URL, "user", "passw");
//    
//        DatabaseMetaData dmd = conn.getMetaData();
//        ResultSet rs1 = dmd.getSchemas();
//        while (rs1.next()) {
//          String ss = rs1.getString(1);
//          ResultSet rs2 = dmd.getTables(null, ss, "%", null);
//          while (rs2.next()) {
//                System.out.println(rs2.getString(3) + " " + rs2.getString(4));
//            }
//        }
//        conn.close();
    }
}
