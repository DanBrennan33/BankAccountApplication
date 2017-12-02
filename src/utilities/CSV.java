package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    // This will read data from a CSV file and return as a list
    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<String[]>();
        String accountInfo;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((accountInfo = br.readLine()) != null) {
                String[] dataInfo = accountInfo.split(",");
                data.add(dataInfo);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return data;
    }
}
