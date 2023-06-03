
package account;

import java.io.Serializable;


public class EmployeeSalary implements Serializable{
    
    private String id,name,username,date,month,year;
    private float amount;

    public EmployeeSalary() {
    }

    public EmployeeSalary(String id, String name, String username, String date, String month, String year, float amount) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.date = date;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return id + "," + name + "," + username + "," + date + "," + month + "," + year + "," + amount+"\n";
    }
    
    
    
}
