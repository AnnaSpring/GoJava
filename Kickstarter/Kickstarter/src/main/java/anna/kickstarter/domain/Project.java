package anna.kickstarter.domain;

import java.util.List;

public class Project {
    private int id;
    private String name;
    private String description;
    private int requiredBudget;
    private int gatheredBudget;
    private int days;
    private String url;
    private String history;
    private List<String> questionsAnswers;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getRequiredBudget() {
        return requiredBudget;
    }
    public void setRequiredBudget(int requiredBudget) {
        this.requiredBudget = requiredBudget;
    }
    public int getGatheredBudget() {
        return gatheredBudget;
    }
    public void setGatheredBudget(int gatheredBudget) {
        this.gatheredBudget = gatheredBudget;
    }
    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getHistory() {
        return history;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    public List<String> getQuestionsAnswers() {
        return questionsAnswers;
    }
    public void setQuestionsAnswers(List<String> questionsAnswers) {
        this.questionsAnswers = questionsAnswers;
    }

    

}
