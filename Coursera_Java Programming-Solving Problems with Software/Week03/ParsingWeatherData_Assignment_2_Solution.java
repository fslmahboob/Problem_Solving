
/**
 * Assignment: Parsing Weather Data for analysis
 * and calculation of metrics with single/multiple files
 * M. Faisal Mahboob
 * 29/02/2024
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class ParsingWeather {
    public CSVRecord coldestHourInFile(CSVParser parser){
        // Start with lowestSoFar as nothing
        CSVRecord lowestSoFar = null;
        // For each row(currentRow) in the CSV File
        for (CSVRecord currentRow : parser){
            // If lowestSoFar is nothing
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            // Otherwise, compare the temperatures and assign lower
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                // Compare now
                if (currentTemp < lowestTemp && currentTemp != -9999){
                    // Update lowestSoFar to currentRow
                    lowestSoFar = currentRow;
                }
            }
        }
        // Return the lowestSoFar as the answer
        return lowestSoFar;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        //System.out.println("Coldest Temp. was " + lowest.get("TemperatureF") + " at " + lowest.get("TimeEST"));
        System.out.println("Coldest Temp. was " + lowest.get("TemperatureF"));
    }
    
    public String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        // Initialise a temp variable to null
        CSVRecord lowestSoFar = null;
        // Initialise name of file to empty string
        String filename = "";
        // Loop through all files to find the lowest temp.
        for (File f : dr.selectedFiles()){
            // For every file, create a new FileResource
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if (currentTemp < lowestTemp){
                    lowestSoFar = currentRow;
                    filename = f.getName();
                }
            }
        }
        // Return file with lowest temp.
        return filename;
    }
    
    public void testFileWithColdestTemperature(){
        String filename = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + filename);
        // Address to the location of the file; hardcoded folder name and year
        FileResource fr = new FileResource("nc_weather/2013/" + filename);
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temp on that day was " + lowest.get("TemperatureF"));
        System.out.println("All the temp. on the coldest day were: ");
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord row : parser){
            System.out.print(row.get("DateUTC"));
            System.out.println(row.get("TemperatureF"));
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        // Start with lowestSoFar as nothing
        CSVRecord lowestSoFar = null;
        // For each row in the CSV File
        for (CSVRecord currentRow : parser){
            // If lowestSoFar is nothing
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            } else {
                if (currentRow.get("Humidity").contains("N") == false){
                    double currentHum = Double.parseDouble(currentRow.get("Humidity"));
                    double lowestHum = Double.parseDouble(lowestSoFar.get("Humidity"));
                    // Compare them
                    if (currentHum < lowestHum){
                    // Update lowestSoFar to currentRow
                    lowestSoFar = currentRow;
                    }
                }
            }
        }
        return lowestSoFar;
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.print("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        // Initialise a temp variable to null
        CSVRecord lowestSoFar = null;
        // Allow dialog box to open multiple files
        DirectoryResource dr = new DirectoryResource();
        // Loop through all files to find lowest humidity
        for (File f : dr.selectedFiles()){
            // For every file, create a new FileResource so we can use getCSVParser method
            FileResource fr = new FileResource(f);
            // Use method to find lowest humidity on the selected file and return a row
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            if (currentRow.get("Humidity").contains("N") == false){
                if (lowestSoFar == null){
                    lowestSoFar = currentRow;
                } else {
                // Convert strings to double
                double currentHum = Double.parseDouble(currentRow.get("Humidity"));
                double lowestHum = Double.parseDouble(lowestSoFar.get("Humidity"));
                // Compare the humidities
                if (currentHum < lowestHum){
                    // Update the humidity value
                    lowestSoFar = currentRow;
                }
            }
                
            }

        }
        return lowestSoFar;
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.print("Lowest Humidity was " + lowest.get("Humidity") + " at " +lowest.get("DateUTC"));
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        // Initialise avg, sum and count variables
        double avg = 0;
        double sum = 0;
        int count = 0;
        // Create StorageResource to store the string temperatures in each row
        StorageResource sr = new StorageResource();
        // Loop through each record and add temperature to Storage Resource
        for (CSVRecord currentRow : parser){
            String currentTemp = currentRow.get("TemperatureF");
            sr.add(currentTemp);
            // Update count variable to get total number of rows
            count += 1;
        }
        for (String item : sr.data()){
            // Convert string temperature to double and add to sum for each row
            sum += Double.parseDouble(item);
        }
        // Calculate and return the average
        avg = sum/count;
        return avg;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        double avg = averageTemperatureInFile(fr.getCSVParser());
        System.out.print("Average temperate in file is: " + avg);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        // // Initialise avg, sum and count variables
        double avgTemp = 0;
        double sumTemp = 0;
        int count = 0;
        StorageResource sr = new StorageResource();
        for (CSVRecord currentRow : parser){
            double currentH = Double.parseDouble(currentRow.get("Humidity"));
            if (currentH >= value){
                sr.add(currentRow.get("TemperatureF"));
            }
        }
        for (String item : sr.data()){
            double currentTemp = Double.parseDouble(item);
            sumTemp += currentTemp;
            count += 1;
        }
        avgTemp = sumTemp/count;
        return avgTemp;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        int value = 80;
        double avgTemp = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), value);
        if (Double.isNaN(avgTemp)){
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average Temp when high humidity is: " + avgTemp);
        }
    }
}
