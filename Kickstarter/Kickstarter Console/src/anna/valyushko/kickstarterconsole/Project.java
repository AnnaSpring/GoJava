package anna.valyushko.kickstarterconsole;

public class Project {
    private String name;
    private String description;
    private int requiredBudget;    
    private int gatheredBudget;
    private int days;
    private String demoVideo;
    private String history;
    private String questionAnswers;
    
    public Project(String name, String description, int requiredBudget, int days, String demoVideo){
        this.name = name;
        this.description = description;
        this.requiredBudget = requiredBudget;
        this.days = days;
        this.demoVideo = demoVideo;
        
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getRequiredBudget() {
        return requiredBudget;
    }
    public int getDays() {
        return days;
    }
    
    public String getDemoVideo() {
        //TODO 
          return demoVideo;
      }
    //TODO complete declaration of fields, getters/setters

}
