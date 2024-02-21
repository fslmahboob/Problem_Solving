import edu.duke.*;
import java.io.File;

public class Part4 {
    public void findWL(){
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.lines()) {
            String s_l = s.toLowerCase();
            if(s_l.indexOf("youtube.com") > 0){
               // Search for double quotes as HTML is returned
               // First double quote
               int i = s_l.indexOf("\"");
               //Second double quote
               int j = s_l.indexOf("\"", i+1);
               
               // Quiz
               int beg = s.lastIndexOf("\"");
               int end = s.lastIndexOf("\"", i+1);
               System.out.println(s.substring(beg+1,end));
               
               //String p = s.substring(i,j);
               //System.out.println("URL: " + p);
            }
        }
    }
}