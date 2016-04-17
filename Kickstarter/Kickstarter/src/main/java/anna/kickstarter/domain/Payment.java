package anna.kickstarter.domain;

public class Payment {
    private int id;
    private int projectId;
    private String cardholderName;
    private String cardNumber;
    private int amount;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getProject_id() {
        return projectId;
    }
    public void setProject_id(int projectId) {
        this.projectId = projectId;
    }
    public String getCardholderName() {
        return cardholderName;
    }
    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    

}
