package anna.valyushko.kickstarterconsole.categorydao;

import java.util.ArrayList;
import java.util.List;

import anna.valyushko.kickstarterconsole.Category;

public class CategoryDAOMemory extends CategoryDAO{
    public List<Category> fillCategories(){
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category("Technologies"));        
        categories.add(new Category("Film"));
        categories.add(new Category("Music"));
        return categories;
    }
}
