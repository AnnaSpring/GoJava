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
    
    

    
    public void printProjects(){        
        for(int i = 0; i < projects.size(); i++){
            System.out.print((i + 1) + " - " + projects.get(i).getName() + ": ");
            System.out.println(projects.get(i).getDescription());
            System.out.print("Need to gather " + projects.get(i).getRequiredBudget() + " in ");
            System.out.println(projects.get(i).getDays() + " days.");
            System.out.println("-----------------------------");
        }
    }
    
}
