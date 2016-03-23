package anna.valyushko.kickstarterconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        if ("file".equals(environmentVar)) {//TODO
            printQuoteFile();
            printCategoriesFile();
        } else if ("memory".equals(environmentVar)) {
            doMemoryStuff();
        } else if ("sql".equals(environmentVar)) {//TODO
            printQuoteSql();
        }
        // pressEnterToContinue();
        
    }

    private static void doMemoryStuff() {//TODO rename this method and TODO smth with the method at all!!!!!!!!!
        CategoryDAO categoryDAO = new CategoryDAOMemory();
        ProjectDAO project = new ProjectDAOMemory();
        MemoryInitializer init = new MemoryInitializer();
        init.addProjectsToCategory1();
        init.addProjectsToCategory2();
        init.addProjectsToCategory3();
        printQuoteMemory();
        while (true) {
            printCategoriesMemory();
            System.out.println("Select category by its number or enter \"0\" to exit:");// TODO print 0 to exit
            int userInputCategory = getMenuItem();
            Category category = null;
            //int userInputProject = getMenuItem();
               
            if (userInputCategory == 1) {
                category = categoryDAO.getCategory().get(userInputCategory-1);
                categoryDAO.printCategoryByIndex(userInputCategory);
                while(true){
                    init.printProjectsOfCategory1();
                    System.out.println("Select project by its number or enter \"0\" to return to the categories:");
                    int userInputProject = getMenuItem();
                    if(userInputProject == 0)
                        break;
                    init.printProjectsByIndexCategory1(userInputProject);                    
                    System.out.println("Enter \"0\" to return to the projects:");
                    userInputProject = getMenuItem();
                    if(userInputProject == 0)
                        continue;
                }
            } else if (userInputCategory == 2) {
                category = categoryDAO.getCategory().get(userInputCategory-1);
                categoryDAO.printCategoryByIndex(userInputCategory);
                while(true){
                    init.printProjectsOfCategory2();
                    System.out.println("Select project by its number or enter \"0\" to return to the categories:");
                    int userInputProject = getMenuItem();
                    if(userInputProject == 0)
                        break;
                    init.printProjectsByIndexCategory2(userInputProject); 
                    System.out.println("Enter \"0\" to return to the projects:");
                    userInputProject = getMenuItem();
                    if(userInputProject == 0)
                        continue;
                }
            } else if (userInputCategory == 3) {
                category = categoryDAO.getCategory().get(userInputCategory-1);
                categoryDAO.printCategoryByIndex(userInputCategory);
                while(true){
                    init.printProjectsOfCategory3();
                    System.out.println("Select project by its number or enter \"0\" to return to the categories:");
                    int userInputProject = getMenuItem();
                    if(userInputProject == 0)
                        break;
                    init.printProjectsByIndexCategory3(userInputProject); 
                    System.out.println("Enter \"0\" to return to the projects:");
                    userInputProject = getMenuItem();
                    if(userInputProject == 0)
                        continue;
                }
            } else if (userInputCategory == 0){
                break;
            } else{
                System.out.println("You enter incorrect number of category. Try again or enter \"0\" to exit");
            }
        }
    }

    private static int getMenuItem() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private static void printCategoriesMemory() {
        CategoryDAO category = new CategoryDAOMemory();
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
