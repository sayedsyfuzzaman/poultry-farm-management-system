package business_controllers;

public class StockDetails extends Stocks {

    private double totalExpense;
    private int currentquantity;
    private double salePrice;
    private int saleQuantity;
    private double Profit;

    public void setExpense(double Expense, double Price) {
        this.totalExpense = Price + Expense;
    }

    public void setCurrentQuantity(int Quantity) {

            this.currentquantity = Quantity;
        
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public double getExpense() {
        return totalExpense;
    }

    public int getCurrentQuantity() {
        return currentquantity;
    }

    public double getSalePrice() {
        return this.salePrice;
    }

    public int getSaleQuantity() {
        return this.saleQuantity;
    }

    public double getProfit() {
        Profit = salePrice - totalExpense;
        return this.Profit;
    }
}
