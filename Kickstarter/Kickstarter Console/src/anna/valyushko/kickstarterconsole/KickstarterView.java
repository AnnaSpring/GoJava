package anna.valyushko.kickstarterconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import anna.valyushko.kickstarterconsole.categorydao.CategoryDAO;
import anna.valyushko.kickstarterconsole.categorydao.CategoryDAOFile;
import anna.valyushko.kickstarterconsole.categorydao.CategoryDAOMemory;
import anna.valyushko.kickstarterconsole.projectdao.ProjectDAO;
import anna.valyushko.kickstarterconsole.projectdao.ProjectDAOMemory;
import anna.valyushko.kickstarterconsole.quotedao.QuoteDAO;
import anna.valyushko.kickstarterconsole.quotedao.QuoteDAOFile;
import anna.valyushko.kickstarterconsole.quotedao.QuoteDAOMemory;
import anna.valyushko.kickstarterconsole.quotedao.QuoteDAOSql;

public class KickstarterView {
    private static final String DAO_MODE = "KICKSTARTER_DAO_MODE";

    public static void run() {
        String environmentVar = System.getenv(DAO_MODE);
        //TODO navigation
        if ("file".equals(environmentVar)) {
            printQuoteFile();
            printCategoriesFile();
        } else if ("memory".equals(environmentVar)) {
            doMemoryStuff();
        } else if ("sql".equals(environmentVar)) {
            printQuoteSql();
        }
        // pressEnterToContinue();
        
        //TODO I see a message about what category I selected
    }

    private static void doMemoryStuff() {
        MemoryInitializer init = new MemoryInitializer();
        printQuoteMemory();
        while (true) {
            printCategoriesMemory();
            System.out.println("Select category by its number or print \"0\" to exit:");// TODO print 0 to exit
            int userInput = getMenuItem();
            //TODO smth with the following полотенце
            if (userInput == 1) {
                printCategoryName(userInput);
                init.addProjectsToCategory1();
                while (true){
                    init.printProjectsOfCategory1();
                    
                }
            } else if (userInput == 2) {
                printCategoryName(userInput);
                init.addProjectsToCategory2();
                init.printProjectsOfCategory2();
            } else if (userInput == 3) {
                printCategoryName(userInput);
                init.addProjectsToCategory3();
                init.printProjectsOfCategory3();
            } else if (userInput == 0){
                break;
            }
        }
    }

    private static String printCategoryName(int userInput) {
        List<Category> categories = null;
        String categoryName = null;
        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i) == categories.get(userInput))
                categoryName = categories.get(i).getName();
        }
        return ("You chose category: " + categoryName);
    }

    private static int getMenuItem() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private static void printCategoriesMemory() {
        CategoryDAO category = new CategoryDAOMemory();
        System.out.println("READ CATEGORIES FROM MEMORY");
        System.out.println();
        category.printCategories();
    }
    private static void printCategoriesFile() {
        CategoryDAO category = new CategoryDAOFile();
        System.out.println("READ CATEGORIES FROM FILE");
        category.printCategories();
    }
    private static void printQuoteMemory() {
        QuoteDAO quote = new QuoteDAOMemory();
        System.out.println("READ QUOTES FROM MEMORY");
        System.out.println(quote.getRandomQuote().getQuote());// TODO get author
                                                              // of the quote
    }

    private static void printQuoteFile() {
        QuoteDAO q = new QuoteDAOFile();
        System.out.println("READ QUOTES FROM FILE");
        System.out.println(q.getRandomQuote().getQuote());// TODO get author of
                                                          // the quote
    }

    private static void printQuoteSql() {
        QuoteDAO q = new QuoteDAOSql();
        q.getRandomQuote().getQuote();
    }

    public static void pressEnterToContinue() {
        System.out.println("Press ENTER to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
