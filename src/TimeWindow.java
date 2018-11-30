import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.text.DateFormat;

public class TimeWindow {
    private Date initialDate;
    private Date finalDate;

    /***
     * Construtor da classe TimeWindow
     * */
    public TimeWindow(String initialDate, String finalDate) throws Exception {
        this.initialDate = formataData(initialDate);
        this.finalDate = formataData(finalDate);
    }

    /***
     * Metodo que formata a data para ser usada pelo sitema.
     * @param data Data que será formatada pelo sistema.
     * @return Date data à ser usada pelo sistema.
     * */
    public Date formataData(String data) throws Exception {
        if (data == null || data.equals(""))
            return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            date = (Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    /***
     * Getter do intervalo de tempo entre as datas iniciais e finais.
     * */
    public void getTimeWindow() {
        System.out.println("Data Inicial: " + initialDate);
        System.out.println("Data Final: " + finalDate);
    }
}