package anna.valyushko.kickstarterconsole.projectdao;

import java.util.List;

import anna.valyushko.kickstarterconsole.Category;
import anna.valyushko.kickstarterconsole.Project;

public abstract class ProjectDAO {
    public List<Project> projects = fillProject();
    
    public abstract List<Project> fillProject();
    
   
    public List<Project> getProject(){
        return projects;
    }
    

    
}
