import java.util.Arrays;
import java.io.*;

public class CsvReader {

    private String csvFile;
    private String line;
    private String csvSplitBy;

    public CsvReader() {
        line = "";
        csvSplitBy = ",";
    };

    public String[] readCsv(String csv) {
        csvFile = csv;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // while ((line = br.readLine()) != null) {
            line = br.readLine();
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