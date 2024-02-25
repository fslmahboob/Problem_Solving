
/**
 * Storing All Genes Assignment - Part 1
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
}
