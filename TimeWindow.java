import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import java.text.DateFormat;

public class TimeWindow {
    private Date initialDate;
    private Date finalDate;

    public TimeWindow(String initialDate, String finalDate) throws Exception {
        this.initialDate = formataData(initialDate);
        this.finalDate = formataData(finalDate);
    }

    public Date formataData(String data) throws Exception {
        if (data == null || data.equals(""))
            return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public void getTimeWindow() {
        System.out.println("Data Inicial: " + initialDate);
        System.out.println("Data Final: " + finalDate);
    }

}