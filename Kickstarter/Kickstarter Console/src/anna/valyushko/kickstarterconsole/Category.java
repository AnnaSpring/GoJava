package anna.valyushko.kickstarterconsole;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Project> projects = new ArrayList<Project>();
    public Category(){
        
    }    
    public Category(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }   
    public String getName(){
        return name;
    }
    
    public void addProject(Project project){
        projects.add(project);
    }
    public List<Project> getProjectsOfCategory(){
        return projects;
    }
    

}
