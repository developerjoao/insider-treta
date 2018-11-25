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

    public void readCsv(String csv) {

        csvFile = csv;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                System.out.println(Arrays.toString(data));
            }
        } catch (IOException e) {
            System.out.print("ronaldo");
            e.printStackTrace();
        }
    }
}