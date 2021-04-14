/*Create a class diagram and Java code for the following system and scenario, taking into account the possibility of
future extensions. "The system is a command line utility that prints a short 'quote of the day' on the user's terminal
when run. To begin with the quote is selected randomly from a set of hard-coded strings within the program itself,
but that might change later on -- the quotes might be based on the user's history, the time of day, the date, etc..
Scenario :
1. User types "java QuoteOfTheDay" on the command line.
2. System prints out a quote of the day, with an attribution.*/

package java_assignments.Assignment04;



public class QuoteOfTheDay {
    public static void main(String args[]){
        Quotes.generate();
        Quotes.ShowQuote();
    }
}
