package anna.kickstarter.dao.projectdao;

import java.util.List;

import anna.kickstarter.domain.Project;

public interface ProjectDAO {
    public abstract List<Project> getProjectsByCategoryId(int category_id);
    
    public abstract Project getProjectById(int project_id);

}
