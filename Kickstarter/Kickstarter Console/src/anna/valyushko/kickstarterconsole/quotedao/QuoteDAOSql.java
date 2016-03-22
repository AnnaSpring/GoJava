package anna.valyushko.kickstarterconsole.quotedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import anna.valyushko.kickstarterconsole.Quote;

public class QuoteDAOSql extends QuoteDAO {

    @Override
    public List<Quote> fillQuotes() {
        List<Quote> result = new ArrayList<Quote>();
        Connection connection = null;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://s14.thehost.com.ua/kickstarterAn";
            connection = DriverManager.getConnection(url, "kickstarterAn",
                    "kickstarterAn");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO extract method or class for connection

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, quote, author FROM quotes order by rand() limit 1");
            while (rs.next()) {
                String author = rs.getString("author");
                String text = rs.getString("quote");
                result.add(new Quote(text, author));
                System.out.println(text + "(" + author + ")");

            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return result;
    }

}
