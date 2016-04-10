package anna.kickstarter.dao.projectdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import anna.kickstarter.domain.Project;

@Repository
public class ProjectDAOSql implements ProjectDAO{

    private static final String SELECT_PROJECTS_BY_CATEGORY_ID = "SELECT id, name FROM project WHERE category_id=?";
    private static final String SELECT_PROJECT_DETAILS = "SELECT id, name, description, required_budget, days_left, history, url FROM project WHERE id=?";

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Project> getProjectsByCategoryId(int category_id) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_PROJECTS_BY_CATEGORY_ID)) {
            statement.setInt(1, category_id);
            ResultSet rs = statement.executeQuery();
            List<Project> projects = new ArrayList<Project>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");                
                Project project = new Project();
                project.setId(id);
                project.setName(name);
                projects.add(project);              
            }
            return projects;
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public Project getProjectById(int project_id) {
        Project project = null;
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT_DETAILS)) {
            statement.setInt(1, project_id);
            ResultSet rs = statement.executeQuery();
            
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int required_budget = rs.getInt("required_budget");
                    int days_left = rs.getInt("days_left");
                    String history = rs.getString("history");
                    String url = rs.getString("url");
                    project = new Project();
                    project.setId(id);
                    project.setName(name);
                    project.setDescription(description);
                    project.setRequiredBudget(required_budget);
                    project.setDays(days_left);
                    project.setHistory(history);
                    project.setUrl(url);
                }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }    
        return project;
    }

}
