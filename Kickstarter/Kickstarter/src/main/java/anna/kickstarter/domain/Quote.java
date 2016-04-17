package anna.kickstarter.domain;

public class Quote {
    private int id;
    private String quote;
    private String author;
    
    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setId(int id) {
        this.id = id;
    }    
    
    public String getQuote(){
        return quote;
    }
    
    public String getAuthor(){
        return author;
    }
    public int getId(){
        return id;
    }
}
