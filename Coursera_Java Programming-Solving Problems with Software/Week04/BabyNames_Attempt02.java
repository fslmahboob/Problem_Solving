
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
        int rank = 0;
        
        int countB = 0;
        int countG = 0;
        
        FileResource fr = new FileResource();
        
        CSVParser parser = fr.getCSVParser(false);
        
        // Loop through each row in the CSV
        for (CSVRecord currentRow : parser){
            if(currentRow.get(1).equals("F")){
                countG += 1;
                if (currentRow.get(1).equals(gender) && currentRow.get(0).equals(name)){
                    rank = countG;
                    break;
                }
            } else {
                countB += 1;
                if (currentRow.get(1).equals(gender) && currentRow.get(0).equals(name)){
                    rank = countB;
                    break;
                }
            }
        }
        if (rank == 0){
            rank = -1;
        }
        return rank;
    }

    public void testgetRank(){
        int rank1 = getRank(2012, "Mason", "M");
        System.out.println("Rank1: " + rank1);
        
        int rank2 = getRank(2012, "Isabella", "F");
        System.out.println("Rank2: " + rank2);
        
        int rank3 = getRank(2012, "Mason", "F");
        System.out.println("Rank3: " + rank3);
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
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        // Get the rank of the current name
        int rank = getRank(year, name, gender);
        // Get the new name for the same rank in the new year
        String newName = getName(newYear, rank, gender);
        
        //System.out.println("New Name: " + newName);
        
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear);
    }
    
    public void testwhatIsNameInYear(){
        whatIsNameInYear("Isabella", 2012, 2014, "F");
    }
}
