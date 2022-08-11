package helpers;

import business_controllers.Customer;
import business_controllers.CustomerLog;
import business_controllers.DeathRecord;
import business_controllers.ExpenseReport;
import business_controllers.Memo;
import business_controllers.SaleLog;
import business_controllers.StockDetails;
import business_controllers.Stocks;
import business_controllers.User;
import configs.SysConfigs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnectionHelper {

    SysConfigs dbcon = new SysConfigs();

    public final ArrayList<User> Userarr = new ArrayList<User>();

    public ArrayList<Stocks> Stocksarr = new ArrayList<Stocks>();

    public ArrayList<Stocks> stockNumber = new ArrayList<Stocks>();

    public ArrayList<Customer> customer = new ArrayList<Customer>();

    public ArrayList<CustomerLog> customerlog = new ArrayList<CustomerLog>();

    public ArrayList<DeathRecord> deathrecord = new ArrayList<DeathRecord>();

    public ArrayList<ExpenseReport> expensereport = new ArrayList<ExpenseReport>();

    public ArrayList<SaleLog> salelog = new ArrayList<SaleLog>();

    public ArrayList<SaleLog> salearr = new ArrayList<SaleLog>();

    public int ID, memo_no, TotalDead, Quantity, Current_quantity;
    public double Expense;
    public String Name, EmployeeName, CustomerName;

    /////////////////////////////////////application specific methods /////////////////////////////////////////
    public int InsertUpdateRowInTable(String query) {
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            int updateResult = stmt.executeUpdate(query);

            stmt.close();
            con.close();

            return updateResult;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR:" + query);
            return 0;
        }
    }

    public boolean checkUser(String username, String password) {

        String sql = "select * from user where username='" + username + "' and password='" + password + "'";
        boolean isUser = false;
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {

                isUser = true;

            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("checkUser Getting Error " + e);

        }

        return isUser;
    }

    public ArrayList getAllUserList() {

        String sql = "select * from user";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("contact");
                String username = resultSet.getString("username");
                String Password = resultSet.getString("password");
                String address = resultSet.getString("address");
                int typeno = resultSet.getInt("type");
                String type;
                if (typeno == 1) {
                    type = "Director";
                } else {
                    type = "Employee";
                }
                User user = new User();
                user.setId(Id);
                user.setName(name);
                user.setPhone(phone);
                user.setAddress(address);
                user.setUsername(username);
                user.setType(type);
                user.setPassword(Password);
                Userarr.add(user);

            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getAllUserList Getting Error " + e);

        }

        return Userarr;
    }

    public User getUser(String Username) {
        User user = new User();
        String sql = "select * from user where username='" + Username + "'";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("contact");
                String username = resultSet.getString("username");
                String Pass = resultSet.getString("password");
                String address = resultSet.getString("address");
                int typeno = resultSet.getInt("type");
                String type;
                if (typeno == 1) {
                    type = "Director";
                } else {
                    type = "Employee";
                }

                user.setId(Id);
                user.setName(name);
                user.setPhone(phone);
                user.setAddress(address);
                user.setUsername(username);
                user.setType(type);
                user.setPassword(Pass);

            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getUser Getting Error " + e);

        }

        return user;
    }

    public String getEmployeeName(int id) {
        String sql = "select name from user where id='" + id + "'";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                EmployeeName = resultSet.getString("name");
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getEmployeeName Getting Error " + e);
        }
        return EmployeeName;
    }

    public boolean checkStockNo(String stockNo) {
        String sql = "select * from stocks where stock_no='" + stockNo + "'";
        boolean isStock = false;
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {

                isStock = true;

            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("checkStockNo Getting Error " + e);

        }
        return isStock;
    }

    public ArrayList getStocks() {

        String sql = "select DATE_FORMAT(st.date, \"%h : %i %p - %d %M, %Y\") as date,st.stock_no,st.type,st.quantity,st.total_dead,st.cost_price,st.expense,st.company,st.comment,us.name from stocks st, user us where st.added_by=us.Id";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                String stock_no = resultSet.getString("stock_no");
                String type = resultSet.getString("type");
                int quantity = resultSet.getInt("quantity");
                double Costprice = resultSet.getDouble("cost_price");
                String company = resultSet.getString("company");
                String date = resultSet.getString("date");
                String comment = resultSet.getString("comment");
                String addedBy = resultSet.getString("name");

                Stocks Stocks = new Stocks();
                Stocks.setStockNo(stock_no);
                Stocks.setType(type);
                Stocks.setQuantity(quantity);
                Stocks.setCostPrice(Costprice);;
                Stocks.setCompany(company);
                Stocks.setDate(date);
                Stocks.setComment(comment);
                Stocks.setAddedBy(addedBy);
                Stocksarr.add(Stocks);
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getStocks Getting Error " + e);

        }

        return Stocksarr;
    }

    public ArrayList fill_StockNo_combo() {
        String sql = "select * from stocks";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                String stock_no = resultSet.getString("stock_no");

                Stocks stocks = new Stocks();
                stocks.setStockNo(stock_no);
                stockNumber.add(stocks);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("fill_StockNo_combo Getting Error ");

        }
        return stockNumber;

    }

    public int getStockID() {
        String sql = "select * from stocks order by ID desc limit 1";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                ID = resultSet.getInt("Id");
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getStockID Getting Error ");

        }
        return ID;
    }

    public int getTotalDead(String Number) {

        String sql = "select * from stocks where stock_no = '" + Number + "'";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                TotalDead = resultSet.getInt("total_dead");
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("total_dead Getting Error ");

        }
        return TotalDead;
    }

    public int getStocksQuantity(String Number) {

        String sql = "select quantity from stocks where stock_no = '" + Number + "'";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                Quantity = resultSet.getInt("quantity");
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("quantity Getting Error ");

        }
        return Quantity;
    }

    public double getStockCurrentExpense(String Number) {

        String sql = "select * from stocks where stock_no = '" + Number + "'";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                Expense = resultSet.getInt("expense");
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("total_dead Getting Error ");

        }
        return Expense;
    }

    public int getCurrentQuantity(String Number) {

        String sql = "select current_quantity from stocks where stock_no = '" + Number + "'";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                Current_quantity = resultSet.getInt("current_quantity");
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getCurrentQuantity Getting Error ");

        }
        return Current_quantity;
    }

    public StockDetails getStockCurrentDetails(String Number) {
        StockDetails stockdetails = new StockDetails();
        String sql = "select DATE_FORMAT(st.date, \"%h : %i %p - %d %M, %Y\") as date,st.stock_no,st.type,st.quantity,st.total_dead,st.cost_price,st.expense,st.company,st.comment,st.sale_quantity,st.current_quantity,st.sale_price,us.name from stocks st, user us where st.added_by=us.Id and st.stock_no = '" + Number + "'";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String StockNo = resultSet.getString("stock_no");
                String Type = resultSet.getString("type");
                int Quantity = resultSet.getInt("quantity");
                int CurrentQuantity = resultSet.getInt("current_quantity");
                double CostPrice = resultSet.getDouble("cost_price");
                String Company = resultSet.getString("company");
                String Date = resultSet.getString("date");
                String Comment = resultSet.getString("comment");
                String AddedBy = resultSet.getString("name");
                double Expense = resultSet.getDouble("expense");
                int TotalDead = resultSet.getInt("total_dead");
                int saleQuantity = resultSet.getInt("sale_quantity");
                double salePrice = resultSet.getDouble("sale_price");

                stockdetails.setStockNo(StockNo);
                stockdetails.setType(Type);
                stockdetails.setQuantity(Quantity);
                stockdetails.setCostPrice(CostPrice);
                stockdetails.setCompany(Company);
                stockdetails.setDate(Date);
                stockdetails.setComment(Comment);
                stockdetails.setAddedBy(AddedBy);
                stockdetails.setExpense(Expense, CostPrice);
                stockdetails.setCurrentQuantity(CurrentQuantity);
                stockdetails.setSaleQuantity(saleQuantity);
                stockdetails.setSalePrice(salePrice);

            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("StockCurrentDetails Getting Error ");

        }
        return stockdetails;
    }

    public int getLastAddedMemoNO() {
        String sql = "select memo_no from memo order by memo_no desc limit 1";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                memo_no = resultSet.getInt("memo_no");
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getMemoNO Getting Error ");

        }
        return memo_no;
    }

    public ArrayList fill_Customer_combo() {
        String sql = "select name from customer";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                String customer_name = resultSet.getString("name");

                Customer customername = new Customer();
                customername.setName(customer_name);
                customer.add(customername);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("customer Getting Error ");

        }
        return customer;

    }

    public Customer getCustomerInfo(String name) {

        Customer customerinfo = new Customer();
        String sql = "select * from customer where name = '" + name + "'";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                int ID = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String company = resultSet.getString("company");
                int employeeID = resultSet.getInt("added_by");
                String added_by = getEmployeeName(employeeID);
                double balance = resultSet.getDouble("balance");
                double purchase = resultSet.getDouble("purchase");
                double paid_balance = resultSet.getDouble("paid_balance");

                customerinfo.setId(ID);
                customerinfo.setName(name);
                customerinfo.setPhone(phone);
                customerinfo.setAddress(address);
                customerinfo.setCompany(company);
                customerinfo.setAddedBy(added_by);
                customerinfo.setBalance(balance);
                customerinfo.setPurchase(purchase);
                customerinfo.setPaidBalance(paid_balance);

            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println("getCustomerInfo Getting Error ");

        }
        return customerinfo;
    }

    public String getCustomerName(int id) {
        String sql = "select name from customer where id= " + id + "";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                CustomerName = resultSet.getString("name");
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getCustomerName Getting Error " + e);
        }
        return CustomerName;
    }

    public Memo getMemoInfo(int MemoNo) {
        Memo memo = new Memo();
        String sql = "select * from memo where memo_no = " + MemoNo + "";
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                int Memonum = resultSet.getInt("memo_no");
                int CustomerID = resultSet.getInt("customer_id");
                String CustomerName = getCustomerName(CustomerID);
                double TotalWeight = resultSet.getDouble("total_weight");
                double TotalQuantity = resultSet.getDouble("total_quantity");
                double TotalPrice = resultSet.getDouble("total_price");
                int Added_by = resultSet.getInt("added_by");
                String EmployeName = getEmployeeName(Added_by);

                memo.setMemoNO(Memonum);
                memo.setCustomerName(CustomerName);
                memo.setSoldBy(EmployeName);
                memo.setTotalPrice(TotalPrice);
                memo.setTotalQuantity(TotalQuantity);
                memo.setTotalWeight(TotalWeight);

            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println("getMemoInfo Getting Error ");
        }
        return memo;
    }

    public ArrayList getSaleLog(int memoNo) {

        String sql = "select DATE_FORMAT(date, \"%h : %i %p - %d %M, %Y\") as date,stock_no,quantity,weight,unit_price,price from sale_log where memo_no = '" + memoNo + "'";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                String StockNo = resultSet.getString("stock_no");
                int quantity = resultSet.getInt("quantity");
                double weight = resultSet.getDouble("weight");
                double UnitPrice = resultSet.getDouble("unit_price");
                double Price = resultSet.getDouble("price");
                String Date = resultSet.getString("date");

                SaleLog log = new SaleLog();;
                log.setDate(Date);
                log.setQuantity(quantity);
                log.setStockNO(StockNo);
                log.setUnitPrice(UnitPrice);
                log.setWeight(weight);
                log.setPrice(Price);
                salelog.add(log);
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getSaleLog Getting Error " + e);

        }

        return salelog;
    }

    public ArrayList getCustomerlog(int id) {

        String sql = "select DATE_FORMAT(date, \"%h : %i %p - %d %M, %Y\") as date,memo_no, pre_balance, purchase, paid_balance,balance,added_by from customer_log where customer_id = " + id + "";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String Date = resultSet.getString("date");
                int MemoNo = resultSet.getInt("memo_no");
                double pre_balance = resultSet.getDouble("pre_balance");
                double purchase = resultSet.getDouble("pre_balance");
                double paid_balance = resultSet.getDouble("paid_balance");
                double balance = resultSet.getDouble("balance");
                int Added_by = resultSet.getInt("added_by");;
                String EmployeName = getEmployeeName(Added_by);

                CustomerLog customer = new CustomerLog();
                customer.setDate(Date);
                customer.setMemoNo(MemoNo);
                customer.setPreBAlance(pre_balance);
                customer.setPurchase(purchase);
                customer.setPaidBalance(paid_balance);
                customer.setBalance(balance);
                customer.setAddedBy(EmployeName);

                customerlog.add(customer);
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getCustomerlog Getting Error " + e);

        }
        return customerlog;
    }

    public ArrayList getDeathRecordLog(String number) {

        String sql = "select DATE_FORMAT(date, \"%h : %i %p - %d %M, %Y\") as date,stock_no, pre_quantity, dead, current_quantity,added_by from death_record where stock_no = '" + number + "'";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String Date = resultSet.getString("date");
                String StockNo = resultSet.getString("stock_no");
                int Prequantity = resultSet.getInt("pre_quantity");
                int dead = resultSet.getInt("dead");
                int CurrentQuantity = resultSet.getInt("current_quantity");
                int Added_by = resultSet.getInt("added_by");;
                String EmployeName = getEmployeeName(Added_by);

                DeathRecord log = new DeathRecord();
                log.setDate(Date);
                log.setAddedby(EmployeName);
                log.setCurrentQuantity(CurrentQuantity);
                log.setDead(dead);
                log.setPreQuantity(Prequantity);
                log.setStockNO(StockNo);
                deathrecord.add(log);
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getDeathRecordLog Getting Error " + e);

        }
        return deathrecord;
    }

    public ArrayList getExpenseHistory(String number) {

        String sql = "select DATE_FORMAT(date, \"%h : %i %p - %d %M, %Y\") as date,stock_no, sector, amount,added_by from expenses where stock_no ='" + number + "'";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String Date = resultSet.getString("date");
                String StockNo = resultSet.getString("stock_no");
                String Sector = resultSet.getString("sector");
                double Amount = resultSet.getDouble("amount");
                int Added_by = resultSet.getInt("added_by");;
                String EmployeName = getEmployeeName(Added_by);

                ExpenseReport log = new ExpenseReport();
                log.setDate(Date);
                log.setSector(Sector);
                log.setStockNO(StockNo);
                log.setAmount(Amount);
                log.setAddedby(EmployeName);
                expensereport.add(log);
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getExpenseHistory Getting Error " + e);

        }
        return expensereport;
    }

    public boolean checkCustomer(String name) {

        String sql = "select name from customer where name='" + name + "'";
        boolean isCustomer = false;
        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {

                isCustomer = true;

            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("checkUser Getting Error " + e);

        }

        return isCustomer;
    }

    public ArrayList getSaleHistory() {

        String sql = "select DATE_FORMAT(date, \"%h : %i %p - %d %M, %Y\") as date,Id, memo_no,stock_no,unit_price,weight,quantity,price from sale_log";

        try {
            Connection con = dbcon.getDBConnection();
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                int Id = resultSet.getInt("Id");
                String stock_no = resultSet.getString("stock_no");
                int MemoNo = resultSet.getInt("memo_no");
                int quantity = resultSet.getInt("quantity");
                double UnitPrice = resultSet.getDouble("unit_price");
                double Weight = resultSet.getDouble("unit_price");
                double Price = resultSet.getDouble("price");
                String date = resultSet.getString("date");

                SaleLog log = new SaleLog();
                log.setDate(date);
                log.setId(Id);
                log.setMemoNo(MemoNo);
                log.setPrice(Price);
                log.setQuantity(quantity);
                log.setStockNO(stock_no);
                log.setUnitPrice(UnitPrice);
                log.setWeight(Weight);
                salearr.add(log);

            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println("getSaleHistory Getting Error " + e);

        }

        return salearr;
    }
}
