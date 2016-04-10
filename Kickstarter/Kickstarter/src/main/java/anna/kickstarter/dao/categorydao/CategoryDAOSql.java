package anna.kickstarter.dao.categorydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import anna.kickstarter.domain.Category;

@Repository
public class CategoryDAOSql implements CategoryDAO {

    private static final String SELECT_CATEGORIES = "SELECT id, name FROM category";
    private static final String SELECT_CATEGORY_BY_ID = "SELECT name FROM category WHERE id=?";
    @Autowired
    private DataSource dataSource;



    @Override
    public Category getCategory(int categoryId) {
        Category category = new Category();
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            statement.setInt(1, categoryId);
            ResultSet rs = statement.executeQuery(SELECT_CATEGORY_BY_ID);
            rs.next();
            String name = rs.getString("name");
            category.setId(categoryId);
            category.setName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;

    }

    @Override
    public List<Category> getCategories(){
        List<Category> categories = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SELECT_CATEGORIES);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category();
                category.setName(name);
                category.setId(id);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
