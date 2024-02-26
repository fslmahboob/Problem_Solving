
/**
 * Storing All Genes Assignment - Parts 1,2,3
 * 
 * M. Faisal Mahboob
 * 26-02-2024
 */
import edu.duke.*;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }
    public String findGene(String dna, int where){
        // find first occurrence of "ATG"
        int startIndex = dna.indexOf("ATG", where);
        // if startIndex is -1, return empty string
        if (startIndex == -1){
            return "";
        }
        // use taa,tag,tga Index to store first occurrences
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        // Return the gene formed from the “ATG” 
        // and the closest stop codon that is a multiple of three away
        int temp = Math.min(taaIndex, tagIndex);
        //store in minIndex the smallest of these three values
        int minIndex = Math.min(temp, tgaIndex);
        // If there is no valid stop codon return the empty string.
        if (minIndex == dna.length()){
            return "";
        }
        // Return the text from startIndex to minIndex
        return dna.substring(startIndex, minIndex+3);
    }
    
    public void testFindStopCodon(){
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9, "TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna, 1, "TAA");
        if (dex != 26) System.out.println("error on 26");
        dex = findStopCodon(dna, 0, "TAG");
        if (dex != 26) System.out.println("error on 26 TAG");
        System.out.println("Tests finished!");
    }
    
    public void testFindGene(){
        // DNA with no 'ATG'
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        System.out.println("DNA: " + dna);
        String gene = findGene(dna, 0);
        System.out.println("Gene: " + gene);
        // DNA with 'ATG' and one valid stop codon
        dna = "xxxATGyyyzzzTAAxxxyyyzzzTAAxx";
        System.out.println("DNA: " + dna);
        gene = findGene(dna, 0);
        System.out.println("Gene: " + gene);
        // DNA with 'ATG' and multiple valid stop codons
        dna = "xxxATGyyyzzzTAAxxxTAGyyyzzzTAAxxTGA";
        System.out.println("DNA: " + dna);
        gene = findGene(dna, 0);
        System.out.println("Gene: " + gene);
        // DNA with 'ATG' and no valid stop codons
        dna = "xxxATGyyyzzzxxxyyyzzzxx";
        System.out.println("DNA: " + dna);
        gene = findGene(dna, 0);
        System.out.println("Gene: " + gene);
    }
    
    public void printAllGenes(String dna){
        // Set startIndex to 0
        int startIndex = 0;
        // Repeat these steps
        while (true) {
            // Find the next gene after startIndex
            String currentGene = findGene(dna, startIndex);
            // If no gene was found, exit loop
            if (currentGene.isEmpty()){
                break;
            }
            // Print the gene
            System.out.println("Gene: " + currentGene);
            // Update startIndex to just past the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
        }
    }
    
        public StorageResource getAllGenes(String dna){
        // Set startIndex to 0
        int startIndex = 0;
        //Create an empty list
        StorageResource geneList  = new StorageResource();
        // Repeat these steps
        while (true) {
            // Find the next gene after startIndex
            String currentGene = findGene(dna, startIndex);
            // If no gene was found, exit loop
            if (currentGene.isEmpty()){
                break;
            }
            // Add gene to StorageResource geneList
            geneList.add(currentGene);
            // Print the gene
            //System.out.println("Gene: " + currentGene);
            // Update startIndex to just past the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
        }
        return geneList;
    }
    
    public double cgRatio(String dna){
        // Initialise counter
        int count = 0;
        // Length of the dna
        int dna_length = dna.length();
        // Initialise starting index to zero
        int startIndex = 0;
        // Counting C's and G's
        int index_C = dna.indexOf("C", startIndex);
        int index_G = dna.indexOf("G", startIndex);
        // Debugging
        //System.out.println("Index C_0: " + index_C); 
        //System.out.println("Index G_0: " + index_G); 
        // Loop through all the dna characters until -1 is returned
        while (startIndex < dna_length){
            if (index_C != -1){
                count += 1;
                index_C = dna.indexOf("C", index_C + 1);
            }
            if (index_G != -1){
                count += 1;
                index_G = dna.indexOf("G", index_G + 1);
            }
            // Debugging
            //System.out.println("Count: " + count);        
            //System.out.println("Index C_1: " + index_C); 
            //System.out.println("Index G_1: " + index_G); 
            // Update the indexes and counter
            startIndex += 1;
        }
        // Debugging
        System.out.println("Count: " + count);
        System.out.println("dna length " + dna_length);
        double cg_R = (float) count/ (float) dna_length;
        return cg_R;
    }
    
    public int countCTG(String dna){
        // Initialise count to zero
        int count = 0;
        // Get list from getAllGenes method
        StorageResource geneList = getAllGenes(dna);
        for (String s : geneList.data()){
            count += 1;
        }
        return count;
    }
    
    public void processGenes(StorageResource sr){
        // Initialise counter for Strings that are longer than 9 characters
        int count1 = 0;
        // Initialise counter for Strings with C-G-ratio is higher than 0.35
        int count3 = 0;
        // Initialise temp variable for finding longest gene
        int temp = 0;
        // Iterate through StorageResource for each string of gene
        for (String s : sr.data()){
            if(s.length() > 9){
                // Print all Strings in sr > 9 characters
                System.out.println("S > 9: " + s);
                count1 += 1;
            }
            int count2 = countCTG(s);
            if (count2 > 0.35){
                // Print all Strings in sr with C-G ratio > 0.35
                System.out.println("S with C-G ratio > 0.35 :" + s);
                count3 += 1;
            }
            if(s.length() > temp){
                temp = s.length();
            }
        }
        // Print number of Strings in sr > 9 characters
        System.out.println("# of S > 9: " + count1);
        // Print number of Strings in sr with C-G ratio > 0.35
        System.out.println("# of S with C-G > 0.35: " + count3);
        // Print the length of the longest gene in sr
        System.out.println("Length of longest gene: " + temp);
    }
    
    public void testprintAllGenes(){
        String dna = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA";
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);
        dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);
        dna = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);
    }
    
    public void testgetAllGenes(){
        String dna = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA";
        // Store the results of all the genes from the dna in a new list
        StorageResource genes = getAllGenes(dna);
        // Iterate over the list
        for (String item: genes.data()){
            System.out.println("Gene: " + item);
        }
    }
    
    public void testcgRatio(){
        String dna = "ATGCCATAG";
        System.out.println("cgRatio: " + cgRatio(dna));
    }
    
    public void testcountCTG(){
        String dna = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA";
        int count = countCTG(dna);
        System.out.println("# of times codon CTG appears: " + count);
        
    }
}
