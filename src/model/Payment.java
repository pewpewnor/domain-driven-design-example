package model;

public class Payment{
    private String currency;
    private Double balance;

    public Payment(String currency, Double balance){
        this.balance = balance;
        this.currency = currency;
    }
    
    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }



}