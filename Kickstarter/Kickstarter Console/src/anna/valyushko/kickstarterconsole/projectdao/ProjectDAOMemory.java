package anna.valyushko.kickstarterconsole.projectdao;

import java.util.ArrayList;
import java.util.List;

import anna.valyushko.kickstarterconsole.Project;

public class ProjectDAOMemory extends ProjectDAO {
    public List<Project> fillProject(){
        List<Project> projects = new ArrayList<Project>();
        
        projects.add(new Project("Film - Java Intro", "How to write programs in Java",
                10000, 15, "https://www.youtube.com/lkfjhsldkjf"));        
        projects.add(new Project("Film - Java Intro", "How to write programs in Java",
                10000, 15, "https://www.youtube.com/lkfjhsldkjf"));        
        projects.add(new Project("Film - Java Intro", "How to write programs in Java",
                10000, 15, "https://www.youtube.com/lkfjhsldkjf"));
        projects.add(new Project("Film - Java Intro", "How to write programs in Java",
                10000, 15, "https://www.youtube.com/lkfjhsldkjf"));
        projects.add(new Project("Film - Java Intro", "How to write programs in Java",
                10000, 15, "https://www.youtube.com/lkfjhsldkjf"));
        projects.add(new Project("Film - Java Intro", "How to write programs in Java",
                10000, 15, "https://www.youtube.com/lkfjhsldkjf"));
        return projects;
    }


}
