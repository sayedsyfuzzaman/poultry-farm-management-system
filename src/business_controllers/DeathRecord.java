package business_controllers;

public class DeathRecord {

    private String StockNO;
    private String Date;
    private String AddedBy;
    private int PreQTY;
    private int Dead;
    private int CurrentQTY;

    public void setStockNO(String StockNO) {
        this.StockNO = StockNO;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }
    public void setAddedby(String AddedBy) {
        this.AddedBy = AddedBy;
    }
    
    public void setPreQuantity(int PreQTY){
        this.PreQTY = PreQTY;
    }
    public void setDead(int Dead){
        this.Dead = Dead;
    }
    public void setCurrentQuantity(int CurrentQTY){
        this.CurrentQTY =CurrentQTY;
    }

    
    public int getPreQuantity(){
        return this.PreQTY;
    }
    public int getDead(){
        return this.Dead;
    }
    public int getCurrentQuantity(){
        return this.CurrentQTY;
    }
    public String getStockNo() {
        return this.StockNO;
    }

    public String getDate() {
        return this.Date;
    }

    public String getAddedBy() {
        return this.AddedBy;
    }
}
