package org.example.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

@XmlRootElement
public class Investment {

    private String transactionId;

    private String owner;

    private double amount;

    public Investment() {
        setTransactionId(UUID.randomUUID().toString());
    }

    public Investment(double amount) {
        setAmount(amount);
    }

    @Override
    public String toString() {
        return "Investment{" +
                "transactionId='" + transactionId + '\'' +
                ", owner='" + owner + '\'' +
                ", amount=" + amount +
                '}';
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("For amount [" + amount + "]");
        }
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
