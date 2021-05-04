/*
Design a Metric class that supports Kilometre to Mile conversion with distance in Kilometre as 
argument and Mile to Kilometre conversion with distance in mile as argument.
Assume, one Mile equals 1.5 Kilometre.
*/



public class Metric {
   public static void main(String args[]){
        if(args.length != 2){
            System.out.println("\tWrong Usage");
            return;
        }
        double value;
        try{
            value = Double.parseDouble(args[0]);
        }catch(NumberFormatException e){
            System.out.println("\tWrong format");
            return;
        }
        String unit;
        if( args[1].equalsIgnoreCase("km") ){ value *= 1.5; unit = "Miles"; }
        else if( args[1].toLowerCase().startsWith("mile") ) { value /= 1.5; unit = "Km"; }
        else{ 
            System.out.println("\tWrong unit"); 
            return;
        }
        System.out.println("\t"+value+" "+unit);
   } 
}
