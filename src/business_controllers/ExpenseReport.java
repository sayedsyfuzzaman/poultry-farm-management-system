package business_controllers;


public class ExpenseReport {
    private String StockNO;
    private double Amount;
    private String Sector;
    private String Date;
    private String AddedBy;
    
    public void setStockNO(String StockNO){
        this.StockNO = StockNO;
    }
    public void setAmount(double Amount){
        this.Amount = Amount;
    }
    public void setSector(String Sector){
        this.Sector =Sector;
    }
    public void setDate(String Date){
        this.Date = Date;
    }
    public void setAddedby(String AddedBy){
        this.AddedBy = AddedBy;
    }
    
    public String getStockNo(){
        return this.StockNO;
    }
    public double getAmount(){
        return this.Amount;
    }
    public String getSector(){
        return this.Sector;
    }
    public String getDate(){
        return this.Date;
    }
    public String getAddedBy(){
        return this.AddedBy;
    }
    
}
