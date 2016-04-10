package anna.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private int id;
    private List<Project> projects = new ArrayList<Project>();

    public String getName(){
        return name;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setProjects(List<Project> projects){
        this.projects = projects;
    }
    public List<Project> getProjects(){
        return projects;
    }
    public void setName(String name) {
        this.name = name;        
    }

}
