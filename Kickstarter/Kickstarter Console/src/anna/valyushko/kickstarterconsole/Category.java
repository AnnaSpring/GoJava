package anna.valyushko.kickstarterconsole;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Project> projects = new ArrayList<Project>();

    public Category(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }   
    public String getName(){
        return name;
    }
    public void setProjects(List<Project> projects){
        this.projects = projects;
    }
    public List<Project> getProjectsOfCategory(){
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
    
    public void printProjectDetails(int i){     
        System.out.println("You chose project: " + projects.get(i-1).getName());
        System.out.println();
        System.out.print(i + " - " + projects.get(i-1).getName() + ": ");
        System.out.println(projects.get(i-1).getDescription());
        System.out.print("Need to gather " + projects.get(i-1).getRequiredBudget() + " in ");
        System.out.println(projects.get(i-1).getDays() + " days.");
        System.out.println("History of the project:\n" + projects.get(i-1).getHistory());
        System.out.println("Demo video is here: " + projects.get(i-1).getDemoVideo());
        //TODO questions and answers
        System.out.println();
    }

}
