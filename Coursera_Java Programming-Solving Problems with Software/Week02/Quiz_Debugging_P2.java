
/**
 * Coursera Assignment and Practice Quiz
 * 
 * M. Faisal Mahboob 
 * 25/02/24
 */
public class P2 {
    public void findAbc(String input){
        int index = input.indexOf("abc");
        //System.out.println(index);
        while (true){
            if (index == -1 || index >= input.length() - 3){
                break;
            }
            System.out.println("Debug index 1: " + index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+3);
            System.out.println("Debug index 2: " + index);
        }
    }
    
    public void test(){
        // findAbc("abcd");
        findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    }
}
