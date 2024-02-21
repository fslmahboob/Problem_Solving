
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int start_index = dna.indexOf("ATG");
        if (start_index == -1){
            return "";
        }
        int end_index = dna.indexOf("TAA",start_index+3);
        if (end_index == -1) {
            return "";
        }
        int count = end_index - start_index;
        if (count % 3 != 0) {
            return "";
        }
        String result = dna.substring(start_index,end_index);
        return result;
    }
    
    public void testSimpleGene() {
        // String with no 'ATG'
        String dna = "TTATAA";
        System.out.println("DNA is: " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        // String with 'ATG' but no 'TAA'
        dna = "CGATGGTTTG";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        // String with no 'ATG' or 'TAA'
        dna = "ATIGTABA";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        // String with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "AATGICGTAATATGGT";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        // String with ATG, TAA and the substring between them is NOT a multiple of 3 (a gene)
        dna = "AATGCGTAATATGGT";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene);
        // String for q1
        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Q1 Gene is: " + gene);
    }
}