package lukuvinkki.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import main.java.lukuvinkki.domain.Tip;

public class TipDao implements Dao<Tip, Integer> {

    private String databaseAddress;

    public TipDao(String databaseAddress) {
        this.databaseAddress = databaseAddress;
    }

    public void addTip(String title, String author, String url, String description) throws SQLException {
        if (title.equals("") || title.trim().length() == 0 ) {
            return;
        }
        
        Tip tip = new Tip(title, author, url, description);
        Connection connection = DriverManager.getConnection(databaseAddress);
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Tip(title, author, url, description) VALUES ( ?, ?, ?, ? )");
        stmt.setString(1, tip.getTitle());
        stmt.setString(2, tip.getAuthor());
        stmt.setString(3, tip.getUrl());
        stmt.setString(4, tip.getDescription());
        stmt.execute();
        stmt.close();
        connection.close();
    }

    @Override
    public Tip findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tip> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
