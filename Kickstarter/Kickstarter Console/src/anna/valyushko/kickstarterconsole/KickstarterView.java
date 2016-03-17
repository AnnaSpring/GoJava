package anna.valyushko.kickstarterconsole;

import java.util.Scanner;

import anna.valyushko.kickstarterconsole.categorydao.CategoryDAO;
import anna.valyushko.kickstarterconsole.categorydao.CategoryDAOFile;
import anna.valyushko.kickstarterconsole.categorydao.CategoryDAOMemory;
import anna.valyushko.kickstarterconsole.quotedao.QuoteDAO;
import anna.valyushko.kickstarterconsole.quotedao.QuoteDAOFile;
import anna.valyushko.kickstarterconsole.quotedao.QuoteDAOMemory;

public class KickstarterView {
    private static final String DAO_MODE = "KICKSTARTER_DAO_MODE";
    
    public static void run() {
        String readEnvVar = System.getenv(DAO_MODE);
        if(readEnvVar.equals("file")){
            printQuoteFile();
            printCategoryFile();
        }else if(readEnvVar.equals("memory")){
            printQuoteMemory();
            printCategoryMemory();
        }

        pressEnterToContinue();
    }

    private static void printCategoryMemory() {
        CategoryDAO category = new CategoryDAOMemory();
        System.out.println("READ CATEGORIES FROM MEMORY");
        category.printCategories();        
    }

    private static void printCategoryFile() {
        CategoryDAO category = new CategoryDAOFile();
        System.out.println("READ CATEGORIES FROM FILE");
        category.printCategories();
    }

    private static void printQuoteMemory() {        
        QuoteDAO quote = new QuoteDAOMemory();
        System.out.println("READ QUOTES FROM MEMORY");
        System.out.println(quote.getRandomQuote().getQuote());//TODO get author of the quote
    }
    
    private static void printQuoteFile() {
        QuoteDAO q = new QuoteDAOFile();
        System.out.println("READ QUOTES FROM FILE");
        System.out.println(q.getRandomQuote().getQuote());//TODO get author of the quote
    }
    public static void pressEnterToContinue(){
        System.out.println("Press ENTER to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
