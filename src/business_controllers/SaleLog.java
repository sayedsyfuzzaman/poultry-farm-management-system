package business_controllers;

public class SaleLog {

    private int Id;
    private int MemoNO;
    private String StockNo;
    private int quantity;
    private double weight;
    private double UnitPrice;
    private double Price;
    private String Date;

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setMemoNo(int MemoNO) {
        this.MemoNO = MemoNO;
    }

    public void setStockNO(String StockNo) {
        this.StockNo = StockNo;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
        this.Price = this.weight * this.UnitPrice;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getMemoNo() {
        return this.MemoNO;
    }

    public String getStockNO() {
        return this.StockNo;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getUnitPrice() {
        return this.UnitPrice;
    }

    public double getPrice() {
        return this.Price;
    }

    public String getDate() {
        return this.Date;
    }

    public int getID() {
        return this.Id;
    }

}
