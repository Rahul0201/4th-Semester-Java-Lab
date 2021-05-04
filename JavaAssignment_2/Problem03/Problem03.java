/*
Take a String input that contains multiple words. Do the following: 
    i) number of times 'a' appears
    ii) number of times "and" appears
    iii) whether it starts with "The"
    iv) put the string into an array of characters
    v) display the tokens in the String
(tokens are the substrings separated by space or @ or .)
*/
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem03 {
    public static void main(String args[]){
        final String delimiters = " @.";
        Scanner scan = new Scanner(System.in);
        boolean THE=false;
        int count_a = 0, count_and = 0;

        System.out.println("\n Enter the string : ");
        String Input = scan.nextLine().trim();
        String input = String.copyValueOf(Input.toCharArray()).toLowerCase();

        int i=0;
        try{
            for(i =0; i<input.length(); i++){
                if( input.charAt(i) == 'a') count_a++;
                if( input.charAt(i) == 'a' && input.charAt(i+1) == 'n' && input.charAt(i+2) == 'd' ) count_and++;
            }
        }catch(StringIndexOutOfBoundsException e){
            i++;
            for( ; i<input.length(); i++)
                if( input.charAt(i) == 'a') count_a++;
        }
        if( Input.startsWith("The") ) THE = true;

        System.out.println("\n\n\ti) 'a' appears : "+count_a+" times.");
        System.out.println("\tii) \"and\" appears : "+count_and+" times.");
        System.out.println("\tiii) Starts with \"The\"  ?  "+THE);

        StringTokenizer tokens = new StringTokenizer(Input,delimiters);
        int numtokensperline = 0;
        System.out.println("\n\tAll Tokens :");
        while(tokens.hasMoreTokens()){
            System.out.print(tokens.nextToken()+"    ");
            numtokensperline++;
            if(numtokensperline > 5){
                numtokensperline = 0;
                System.out.println();
            }
        }
    }
    
}
