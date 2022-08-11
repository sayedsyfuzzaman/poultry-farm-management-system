package business_controllers;

public class Customer {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String company;
    private String added_by;
    private double balance;
    private double purchase;
    private double paid_balance;
    
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
     this.name = name;   
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public void setAddedBy(String added_by){
        this.added_by = added_by;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setPurchase(double purchase){
        this.purchase = purchase;
    }
    public void setPaidBalance(double paid_balance){
        this.paid_balance = paid_balance;
    }
    
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getAddress(){
        return this.address;
    }
    public String getCOmpany(){
        return this.company;
    }
    public String getAddedBy(){
        return this.added_by;
    }
    public double getBalance(){
        return this.balance;
    }
    public double getPurchase(){
        return this.purchase;
    }
    public double getPaidBalance(){
        return this.paid_balance;
    }
}
