package anna.kickstarter.quotedao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import anna.kickstarter.domain.Quote;

@Repository
public class QuoteDAOSql implements QuoteDAO {

    private static final String SELECT_QUOTE = "SELECT author, quote FROM quotes order by rand() limit 1";
    @Autowired
    private DataSource dataSource;

    public Quote getRandomQuote() {
        String author = null;
        String quote = null;
        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SELECT_QUOTE);
            rs.next();
            author = rs.getString("author");
            quote = rs.getString("quote");
        }
        catch (SQLException e) {
            //throw new RuntimeException(e.getMessage(), e);
            e.printStackTrace();
        }
        return new Quote(quote, author);
    }


}
