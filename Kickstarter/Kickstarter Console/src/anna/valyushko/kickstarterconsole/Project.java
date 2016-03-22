package anna.valyushko.kickstarterconsole;

import java.util.List;

public class Project {
    private String name;
    private String description;
    private int requiredBudget;
    private int gatheredBudget;
    private int days;
    private String demoVideo;
    private String history;
    private List<String> questionsAnswers;

    public Project(String name, String description, int requiredBudget,
            int days, String demoVideo) {
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
        return demoVideo;
    }
    public String getHistory() {
        return history;
    }
    public List<String> getQuestionsAnswers() {
        return questionsAnswers;
    }
    
    public void setHistory(String history) {
        this.history = history;
    }public void setQuestionsAnswers(List<String> questionsAnswers){
        this.questionsAnswers = questionsAnswers;
    }
    

}
