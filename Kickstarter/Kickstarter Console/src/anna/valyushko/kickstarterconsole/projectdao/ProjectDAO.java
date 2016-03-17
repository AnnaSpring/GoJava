package anna.valyushko.kickstarterconsole.projectdao;

import java.util.List;

import anna.valyushko.kickstarterconsole.Category;
import anna.valyushko.kickstarterconsole.Project;

public abstract class ProjectDAO {
    public List<Project> projects = fillProject();
    
    public abstract List<Project> fillProject();
    
    
    public void printProjects(){
        for(int i = 1; i < projects.size() + 1; i++){
            System.out.print(i + " - " + projects.get(i).getName() + ": ");
            System.out.println(projects.get(i).getDescription());
            System.out.println("Need to gather " + projects.get(i).getRequiredBudget() + " in ");
            System.out.println(projects.get(i).getDays() + " days.");
        }
    }
    
}
