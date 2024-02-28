
/**
 * Assignment: Parsing Export Data
 * 
 * M. Faisal Mahboob
 * 28/02/2024
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Assignment1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.print(countryInfo(parser, "Nauru"));
        //listExportersTwoProducts(parser, "gold", "diamonds");
        //System.out.print(numberOfExporters(parser, "gold"));
        bigExporters(parser, "$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country){
        String c = "";
        String e = "";
        String v = "";
        for (CSVRecord record : parser){
            // Look at Country column after creating CSVRecord class
            String C_export = record.get("Country");
            // Check if it contains the country inputted
            if (C_export.contains(country)){
                // Store the strings in variables for return statement
                c = record.get("Country") + ": ";
                e = record.get("Exports") + ": ";
                v = record.get("Value (dollars)");
                }
            }
            if (c.equals("")){
                return "NOT FOUND";
            }
        return c + e + v;
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        // Initialise the whole string exports variable
        String e_0 = "";
        // Initialise the string country variable
        String c_0 = "";
        // Initialise the separate strings
        String c_1 = "";
        for (CSVRecord record : parser){
            e_0 = record.get("Exports");
            c_0 = record.get("Country");
            // Debugging print statement
            //System.out.println(c_0);
            if (e_0.contains(exportItem1) && e_0.contains(exportItem2)){
                System.out.println(c_0);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        // Initialise the number of countries counter
        int n = 0;
        for (CSVRecord record: parser){
            if (record.get("Exports").contains(exportItem)){
                n += 1;
            }
        }
        return n;
    }
    
    public void bigExporters(CSVParser parser, String amt){
        for (CSVRecord record: parser){
            String v = record.get("Value (dollars)");
            if (v.length() > amt.length()){
                System.out.print(record.get("Country") + " ");
                System.out.println(v);
            }
        }
    }
}
