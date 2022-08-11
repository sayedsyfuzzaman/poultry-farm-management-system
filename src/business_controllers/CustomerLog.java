package business_controllers;

public class CustomerLog extends Customer{
    private int MemoNo;
    private double PreBAlance;
    private String Date;
    
    public void setPreBAlance(double PreBAlance){
        this.PreBAlance = PreBAlance;
    }
    public double getPreBAlance(){
        return this.PreBAlance;
    }
    
    public void setMemoNo(int MemoNo){
        this.MemoNo = MemoNo;
    }
    public int getMemoNo(){
        return this.MemoNo;
    }
    
    public void setDate(String Date){
        this.Date = Date;
    }
    public String getDate(){
        return this.Date;
    }
}
