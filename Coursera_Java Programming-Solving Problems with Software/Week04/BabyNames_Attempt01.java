
/**
 * MiniProjects Exercise: Baby Names
 * 
 * M. Faisal Mahboob
 * 02/03/2024
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
    public void totalBirths(){
        // Initialise the counters
        int numB = 0;
        int numG = 0;
        int numT = 0;
        
        int namesB = 0;
        int namesG = 0;
        int namesT = 0;
        
        FileResource fr = new FileResource();
        for (CSVRecord currentRow : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(currentRow.get(2));
            numT += numBorn;
            if (currentRow.get(1).equals("F")){
                numG += numBorn;
                namesG += 1;
            } else {
                numB += numBorn;
                namesB += 1;
            }
            // Count the total number of names (i.e. rows)
            namesT += 1;
        }
        System.out.println("Grand Total: " + numT);
        System.out.println("Girls Total: " + numG);
        System.out.println("Boys Total: " + numB);
        System.out.println("Total Names: " + namesT);
        System.out.println("Total Names Boys: " + namesB);
        System.out.println("Total Names Girls: " + namesG);
    }
    
    public int getRank(int year, String name, String gender){
        long rank = 0;
        long namesG = 0;
        
        // Allow dialog box to open multiple files
        DirectoryResource dr = new DirectoryResource();
        
        // Loop through all files to select the right file with year
        for (File f: dr.selectedFiles()){
            String fname = f.getName();
            if (fname.contains(Integer.toString(year))){
                // For that file, create a new FileResource so we can use getCSVParser method
                FileResource fr = new FileResource(f);
                CSVParser parser = fr.getCSVParser(false);
                for (CSVRecord currentRow : parser){
                    // String variable that stores name of each row
                    String n = currentRow.get(0);
                    // String variable that stores gender of each row
                    String g = currentRow.get(1);
                    if (g.equals("F")){
                    // Count the total number of rows of girls as they are the top
                    namesG += 1;
                    }
                    if (n.equals(name) && g.equals(gender)){
                        rank = parser.getCurrentLineNumber();
                    } else if (n.equals(name) && g.equals(gender)){
                        rank = parser.getCurrentLineNumber() - namesG;
                    } else{
                        rank = -1;
                    }
                }
            }
        }
        return (int)rank;
    }

    public void testgetRank(){
        int rank = getRank(2012, "Mason", "F");
        System.out.println("Rank: " + rank);
    }
    
    public String getName(int year, int rank, String gender){
        // Initialise current rankings counter to zero
        int namesG = 0;
        int namesB = 0;
        
        // Initialise String name
        String name = "";
        
        // Allow dialog box to open multiple files
        DirectoryResource dr = new DirectoryResource();
        
        // Loop through all the files to select the right file with year
        for (File f : dr.selectedFiles()){
            String fname = f.getName();
            if (fname.contains(Integer.toString(year))){
                // For that file, new FileResource for getCSVParser
                FileResource fr = new FileResource(f);
                CSVParser parser = fr.getCSVParser(false);
                // Loop through each row in CSV to create the rankings
                for (CSVRecord row : parser){
                    // String variable that stores the gender of each row
                    String g = row.get(1);
                    if (g.equals("F")){
                        namesG += 1;
                        if (rank == namesG && g.equals(gender)){
                            name = row.get(0);
                            break;
                        }
                    } else {
                        namesB += 1;
                        if (rank == namesB && g.equals(gender)){
                            name = row.get(0);
                            break;
                        }
                    }
                }
            }
        }
        if (name.length() == 0){
            name = "NO NAME";
        }
        return name;
    }
    
    public void testgetName(){
        String name = getName(2012, 3, "F");
        System.out.println("Name at ranking: " + name);
    }
    
    //public void whatIsNameInYear(String name, int year, int newYear, string gender){
        
    //}
}
