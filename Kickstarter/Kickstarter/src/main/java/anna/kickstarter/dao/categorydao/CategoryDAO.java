package anna.kickstarter.dao.categorydao;

import java.util.List;

import anna.kickstarter.domain.Category;

public interface CategoryDAO {
    Category getCategory(int index);    
    List<Category> getCategories();

}
