package anna.valyushko.kickstarterconsole.quotedao;


import java.util.List;
import java.util.Random;

import anna.valyushko.kickstarterconsole.Quote;

public abstract class QuoteDAO {
    private List<Quote> quotes = fillQuotes();
    
    public abstract List<Quote> fillQuotes();
    
    public Quote getRandomQuote(){
        int index = new Random().nextInt(quotes.size());
        Quote randomQuote = quotes.get(index);
        return randomQuote;
    }
}