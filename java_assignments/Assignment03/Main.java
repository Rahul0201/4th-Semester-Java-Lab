/*Write a program Parentheses.java that reads in a text stream from standard input and uses a stack to determine
whether or not its parentheses are properly balanced. For example, your program should print true for
[()]{}{[()()]()} and false for [(]). You need to implement the stack class by yourself.*/


package java_assignments.Assignment03;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Stack<Character> stk = new Stack<Character>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the text : ");
        String sequence = input.nextLine();

        boolean status = true;
        for(int i=0; i <sequence.length(); i++){
            if( sequence.charAt(i) == '[' || sequence.charAt(i) == '{' || sequence.charAt(i) == '('  ){
                stk.push(sequence.charAt(i));
            }else if( sequence.charAt(i) == ']' || sequence.charAt(i) == '}' || sequence.charAt(i) == ')'  ){ 
                char next = sequence.charAt(i);
                if( stk.IsEmpty() ){status = false;}
                else{
                    char now =stk.pop();
                    switch(next){
                        case ']' :
                            if( now == '[' ){ ; }
                            else{ status = false; }
                            break;
                        case '}' :
                            if( now == '{' ){ ; }
                            else{ status = false; }
                            break;
                        case ')' :
                            if( now == '(' ){ ; }
                            else{ status = false; }
                            break;
                    }
                }
                if(!status){
                    break;
                }
            }
        }
        if( stk.pop() == null && status){
             System.out.println("TRUE"); 
        }else{ status = false; }
        if(!status){
            System.out.println("FALSE");
        }
    }
}
