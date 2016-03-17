package anna.valyushko.kickstarterconsole.quotedao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import anna.valyushko.kickstarterconsole.Quote;

public class QuoteDAOFile extends QuoteDAO{
    private final String QUOTES_FILE_NAME = "./resources/quotes.txt";

    @Override
    public List<Quote> fillQuotes() {//TODO I've stole this method from D.Borisenko
        List<Quote> quotes = new ArrayList<Quote>();
        try (BufferedReader is = new BufferedReader(new FileReader(QUOTES_FILE_NAME))) {
            String line;
            while ((line = is.readLine()) != null) {
                String[] quoteParts = line.split("#");
                Quote quote = new Quote(quoteParts[0], quoteParts[1]);
                quotes.add(quote);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quotes;
    }
    
}
