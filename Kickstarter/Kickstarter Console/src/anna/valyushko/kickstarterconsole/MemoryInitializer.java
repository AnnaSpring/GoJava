package anna.valyushko.kickstarterconsole;

import java.util.ArrayList;
import java.util.List;

import anna.valyushko.kickstarterconsole.categorydao.CategoryDAO;
import anna.valyushko.kickstarterconsole.categorydao.CategoryDAOMemory;
import anna.valyushko.kickstarterconsole.projectdao.ProjectDAO;
import anna.valyushko.kickstarterconsole.projectdao.ProjectDAOMemory;
import anna.valyushko.kickstarterconsole.Category;

public class MemoryInitializer {
    CategoryDAO categoryDAO = new CategoryDAOMemory();
    ProjectDAO projectDAO = new ProjectDAOMemory();

    Category category1 = categoryDAO.getCategory().get(0);
    Category category2 = categoryDAO.getCategory().get(1);
    Category category3 = categoryDAO.getCategory().get(2);

    public void addProjectsToCategory1() {
        List<Project> projects1 = new ArrayList<Project>();
        projects1.add(projectDAO.getProject().get(0));
        projects1.add(projectDAO.getProject().get(1));
        category1.setProjects(projects1);
    }
    public void addProjectsToCategory2() {
        List<Project> projects2 = new ArrayList<Project>();
        projects2.add(projectDAO.getProject().get(2));
        projects2.add(projectDAO.getProject().get(3));
        category2.setProjects(projects2);
    }
    public void addProjectsToCategory3() {
        List<Project> projects3 = new ArrayList<Project>();
        projects3.add(projectDAO.getProject().get(4));
        projects3.add(projectDAO.getProject().get(5));
        category3.setProjects(projects3);
    }

    public void printProjectsOfCategory1() {
        category1.printProjects();
    }
    public void printProjectsOfCategory2() {
        category2.printProjects();
    }
    public void printProjectsOfCategory3() {
        category3.printProjects();
    }
    
    public void printProjectsByIndexCategory1(int i){
        category1.printProjectDetails(i);
    }
    public void printProjectsByIndexCategory2(int i){
        category2.printProjectDetails(i);
    }
    public void printProjectsByIndexCategory3(int i){
        category3.printProjectDetails(i);
    }
    /*
     * Category category3 = categoryDAO.getCategory().get(2);
     * category3.addProject(projectDAO.getProject().get(4));
     * category3.addProject(projectDAO.getProject().get(5));
     */

}
