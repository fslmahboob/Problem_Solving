
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){        
        int start_index = dna.indexOf(startCodon);
        if (start_index == -1){
            return "";
        }
        int end_index = dna.indexOf(stopCodon,start_index+3);
        if (end_index == -1) {
            return "";
        }
        int count = end_index - start_index;
        if (count % 3 != 0) {
            return "";
        }
        String result = dna.substring(start_index,end_index);
        if (dna.equals(dna.toUpperCase())){
            // make result uppercase
            result = result.toUpperCase();
        }
        else if (dna.equals(dna.toLowerCase())){
            // make result lowercase
            result = result.toLowerCase();
        }
        
        return result;
    }
    
    public void testSimpleGene() {
        // String with no 'ATG'
        String dna = "TTATAA";
        System.out.println("DNA is: " + dna);
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        // String with 'ATG' but no 'TAA'
        dna = "CGATGGTTTG";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        // String with no 'ATG' or 'TAA'
        dna = "ATIGTABA";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        // String with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "AATGICGTAATATGGT";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        // String with ATG, TAA and the substring between them is NOT a multiple of 3 (a gene)
        dna = "AATGCGTAATATGGT";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        // String with lowercase
        dna = "gatgctataat";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna, "atg", "taa");
        System.out.println("Gene is: " + gene);
        // String with uppercase
        dna = "ATGGGTTAAGTC";
        System.out.println("DNA is: " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
    }

}
