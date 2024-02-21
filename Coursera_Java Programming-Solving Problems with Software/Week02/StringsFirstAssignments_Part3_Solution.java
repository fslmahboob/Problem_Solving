
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public Boolean twoOccurrences (String stringa, String stringb){
        int i = stringb.indexOf(stringa);
        // if method returns -1 or 0, return false 
        if (i < 1){
            return false;
        // if method returns something else, check for case 1 or case 2
        } else {
            if (stringb.indexOf(stringa, i+1) > 0){
                return true;
            } else {
                return false;
            }
        }
    }
    
    public String lastPart(String stringa, String stringb){
        int i = stringb.indexOf(stringa);
        if (i > 0){
            return stringb.substring(i+stringa.length());
        } else{
            return stringb;
        }
    }
    
    public void testing(){
        String stringa = "by";
        String stringb = "A story by Abby Long";
        Boolean tf = twoOccurrences(stringa, stringb);
        System.out.println("Case 1: " + tf);
        
        stringa = "a";
        stringb = "banana";
        tf = twoOccurrences(stringa, stringb);
        System.out.println("Case 2: " + tf);
        
        stringa = "atg";
        stringb = "ctgtatgta";
        tf = twoOccurrences(stringa, stringb);
        System.out.println("Case 3: " + tf);
        
        stringa = "an";
        stringb = "banana";
        String lp = lastPart(stringa, stringb);
        System.out.println("LP Case 1: " + lp);
        
        stringa = "zoo";
        stringb = "forest";
        lp = lastPart(stringa, stringb);
        System.out.println("LP Case 2: " + lp);
    }
}
