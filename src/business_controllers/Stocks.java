package business_controllers;

public class Stocks {

    private String StockNo;
    private String Type;
    private int Quantity;
    private double CostPrice;
    private String Company;
    private String Date;
    private String Comment;
    private String AddedBy;
    

    public void setStockNo(String StockNo) {
        this.StockNo = StockNo;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setCostPrice(double CostPrice) {
        this.CostPrice = CostPrice;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public void setAddedBy(String AddedBy) {
        this.AddedBy = AddedBy;
    }

    public String getStockNo() {
        return this.StockNo;
    }

    public String getType() {
        return this.Type;
    }

    public int getQuantity() {
        return this.Quantity;
    }

    public double getPrice() {
        return this.CostPrice;
    }

    public String getCompany() {
        return this.Company;
    }

    public String getDate() {
        return this.Date;
    }

    public String getComment() {
        return this.Comment;
    }

    public String getAddedBy() {
        return this.AddedBy;
    }
}
