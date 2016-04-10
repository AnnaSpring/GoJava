package anna.kickstarter.quotedao;



import anna.kickstarter.domain.Quote;

public interface QuoteDAO {
    public abstract Quote getRandomQuote();
    //public abstract void closeStatement(Statement statement);
}
