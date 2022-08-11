package utils;

import helpers.DBConnectionHelper;
import java.util.Calendar;

public class StockNo_Generator {

    DBConnectionHelper db = new DBConnectionHelper();
    private int initial = db.getStockID();
    private int show = db.getStockID();
    
    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    
    String Ye = String.valueOf(year);
    

    public String StockNo_Generator() {
        initial++;
        String ID = Ye.substring(2,4) + "-" + initial + "-" + month;  
        return ID;
    }

    public String StockNo_show() {
        show++;
        String showId = Ye.substring(2,4) + "-" + show + "-" + month;       
        return showId;
    }

}
