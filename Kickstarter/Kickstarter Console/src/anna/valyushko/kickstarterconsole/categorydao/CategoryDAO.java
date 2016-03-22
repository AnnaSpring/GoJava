package anna.valyushko.kickstarterconsole.categorydao;

import java.util.List;

import anna.valyushko.kickstarterconsole.Category;

public abstract class CategoryDAO {

    private List<Category> categories = fillCategories();
    public abstract List<Category> fillCategories();

    public void printCategories() {
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + " - " + categories.get(i).getName());
        }
    }
    public List<Category> getCategory() {
        return categories;
    }
    public Category get(int i){
        return categories.get(i);
    }

}
