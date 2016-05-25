package anna.kickstarter.domain;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class QuoteTest {
    private Quote quote = new Quote();
    @Test
    public void testQuote(){
        int id = 27;
        String author = "Coco Chanel";
        String quoteText = "A women who doesn't wear perfume has no future";
        
        quote.setId(id);
        quote.setAuthor(author);
        quote.setQuote(quoteText);
        
        assertThat(quote.getId(), is(id));
        assertThat(quote.getAuthor(), is(author));
        assertThat(quote.getQuote(), is(quoteText));        
    }

}
