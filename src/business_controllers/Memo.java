
package business_controllers;

public class Memo {
    private int MemoNo;
    private String CustomerName;
    private double TotalWeight;
    private double TotalQuantity;
    private double TotalPrice;
    private double UnitPrice;
    private String SoldBy;
    
    public void setMemoNO(int MemoNo){
        this.MemoNo = MemoNo;
    }
    public int getMemoNo(){
        return this.MemoNo;
    }
    public void setCustomerName(String CustomerName){
        this.CustomerName = CustomerName;
    }
    public String getCustomerName(){
        return this.CustomerName;
    }
    
    public void setTotalWeight(double TotalWeight){
        this.TotalWeight = TotalWeight;
    }
    public double getTotalWeight(){
        return this.TotalWeight;
    }
    
    public void setTotalQuantity(double TotalQuantity){
        this.TotalQuantity = TotalQuantity;
    }
    public double getTotalQuantity(){
        return this.TotalQuantity;
    }
    
    public void setTotalPrice(double TotalPrice){
        this.TotalPrice = TotalPrice;
    }  
    public double getTotalPrice(){
        return this.TotalPrice;
    }
    
    public void setUnitPrice(double UnitPrice){
        this.UnitPrice = UnitPrice;
    }
    public double getUnitPrice(){
        return this.UnitPrice;
    }
    public void setSoldBy(String SoldBy){
        this.SoldBy = SoldBy;
    }
    public String getSoldBy(){
        return this.SoldBy;
    }
}
