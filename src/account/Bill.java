
package account;

import java.io.Serializable;


public class Bill implements Serializable{
    private String id,fullname,username,date,billId,month,year,status;
    private float amount;

    public Bill() {
    }

    public Bill(String id, String fullname, String username, String date, String billId, String month, String year, float amount) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.date = date;
        this.billId = billId;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public Bill(String month, String year, String status) {
        this.month = month;
        this.year = year;
        this.status = status;
    }

    public Bill(String username, String month, String year, float amount) {
        this.username = username;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    
    
    
    
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id + "," + fullname + "," + username + "," + date + "," + billId + "," + month + "," + year + "," + amount+"\n";
    }
    
    
}
