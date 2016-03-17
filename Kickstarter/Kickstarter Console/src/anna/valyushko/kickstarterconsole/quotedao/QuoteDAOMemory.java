package anna.valyushko.kickstarterconsole.quotedao;

import java.util.ArrayList;
import java.util.List;

import anna.valyushko.kickstarterconsole.Quote;

public class QuoteDAOMemory extends QuoteDAO {

    @Override
    public List<Quote> fillQuotes() {
        List<Quote> quotes = new ArrayList<Quote>();
        quotes.add(new Quote("In order to succeed, we must first believe that we can.", "Nikos Kazantzakis"));
        quotes.add(new Quote("What you do today can improve all your tomorrows.", "Ralph Marston"));
        quotes.add(new Quote("A women who doesn't wear perfume has no future.", "Coco Chanel"));
        quotes.add(new Quote("If opportunity doesn't knock, build a door.", "Milton Berle"));
        quotes.add(new Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"));
        return quotes;
    }

}
