package anna.kickstarter;

import anna.kickstarter.categorydao.CategoryDAO;
import anna.kickstarter.categorydao.CategoryDAOSql;
import anna.kickstarter.projectdao.ProjectDAO;
import anna.kickstarter.projectdao.ProjectDAOSql;
import anna.kickstarter.quotedao.QuoteDAO;
import anna.kickstarter.quotedao.QuoteDAOSql;


public class SwitcherDAO {
    
    public QuoteDAO getQuoteDAOMode(){
        QuoteDAO quoteDAO = new QuoteDAOSql();
        return quoteDAO;        
    }
    public CategoryDAO getCategoryDAOMode(){
        CategoryDAO categoryDAO = new CategoryDAOSql();
        return categoryDAO;
    }
    public ProjectDAO getProjectDAOMode() {
        ProjectDAO projectDAO = new ProjectDAOSql();
        return projectDAO;
    }

}

