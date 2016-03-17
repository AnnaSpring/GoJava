package anna.valyushko.kickstarterconsole.categorydao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import anna.valyushko.kickstarterconsole.Category;

public class CategoryDAOFile extends CategoryDAO {
    private static final String CATEGORIES_FILE_NAME = "./resources/categories.txt";


    @Override
    public List<Category> fillCategoryName() {
        List<Category> categories = new ArrayList<Category>();
        try (BufferedReader is = new BufferedReader(new FileReader(CATEGORIES_FILE_NAME))) {
            String line;
            while ((line = is.readLine()) != null) {
                categories.add(new Category(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
    

}
