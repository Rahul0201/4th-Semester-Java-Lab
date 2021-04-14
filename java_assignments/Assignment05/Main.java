/*Indexing a book. Write a program that reads in a text file from standard input and compiles an alphabetical index
of which words/phrases appear on which lines, as in the following input. Ignore case and punctuation. For each
word maintain a list of location on which it appears. Try to use HashTable and/or HashMap class (of java.util).

Note:   key of HashMap : word or phrase
        Value of HashMap can be single or multiple(if multiple time occurs)--*/ 

package java_assignments.Assignment05;

import java.util.*;

public class Main {
    static String prepareDelimiterString() { 
        //Return all character which are NOT part of words, for delimiters in Stringtokenizer
        StringBuilder delimBuilder = new StringBuilder(Character.MAX_VALUE);

        for(int c = Character.MIN_VALUE; c <= Character.MAX_VALUE; c++)
            if( !(Character.isLetter((char)c) || Character.isDigit((char)c)) ) 
                delimBuilder.append((char)c);

        return delimBuilder.toString();
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, HashSet<Integer>> Indextable = new HashMap<String, HashSet<Integer>>();
        final String delimiters = prepareDelimiterString(); 
        int line = 0;

        while(scan.hasNextLine()) {
            line++; 
            StringTokenizer words = new StringTokenizer(scan.nextLine().toLowerCase(), delimiters);
            while(words.hasMoreTokens()) {
                String word = words.nextToken();
                HashSet<Integer> numbers = (Indextable.containsKey(word)) ? Indextable.get(word) : new HashSet<Integer>();
                numbers.add(line); 
                Indextable.put(word, numbers);
            }
        }
        System.out.println("Word: \t\t\t [Set of line numbers]\n");
        for(String word : Indextable.keySet()) 
            System.out.println(word+": \t\t\t "+Indextable.get(word));
    }
}

