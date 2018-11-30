import java.util.Arrays;
import java.io.*;
import java.util.ArrayList;

public class CsvReader {

    private String csvFile;
    private String line;
    private String csvSplitBy;

    /***
     * Construtor do leitor de CSV
     * */
    public CsvReader() {
        line = "";
        csvSplitBy = ",";
    };

    /***
     * Método que vai ler as linhas do CSV.
     * @param csv Linha do csv para ser lida
     * @return Array de dados que serão separados para serem tratados pelo sistema.
     * */
    public String[] readCsv(String csv) {
        csvFile = csv;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // while ((line = br.readLine()) != null) {
            line = br.readLine();
            String[] data = line.split(csvSplitBy);
            System.out.println(Arrays.toString(data));
            return data;
            // }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}