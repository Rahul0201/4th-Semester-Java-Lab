/*
Consider a wrapper class for a numeric basic type. Check the support for the following: 
conversion from i) basic type to object 
                ii) object to basic type
                iii) basic type to String 
                iv) String (holding numeric data) to numeric object
                v) object to String.
*/


public class Problem04 {
    public static void main(String args[]){
        Double d_object;
        double d_basic;
        
        System.out.println("\n\tbasic type to object :");
        d_basic = 123.456;
        d_object = d_basic;
        System.out.println("123.456 is assigned to basic type.");
        System.out.println("Basic numeric datatype contains : "+d_basic);
        System.out.println("Wrapper object contains :         "+d_object);
        
        System.out.println("\n\tobject to basic type :");
        d_object = 456.123; 
        d_basic = d_object;
        System.out.println("456.123 is assigned to wrapper object.");
        System.out.println("Basic type contains :         "+d_basic);

        System.out.println("\n\tBasic type to string :");
        d_basic = 789.456;
        String basicString = String.valueOf(d_basic);
        System.out.println("789.456 is assigned to basic type.\nafter toString() method is called : ");
        System.out.println("Printing string containing value of basic type : "+basicString);

        System.out.println("\n\tString to object :");
        String str = "963.852";
        d_object = Double.parseDouble(str);
        System.out.println("String str contains \"963.852\".");
        System.out.println("Wrapper object contains :         "+d_object);

        System.out.println("\n\tobject to string :");
        d_object = 789.456;
        System.out.println("789.456 is assigned to basic type.\nafter toString() method is called : ");
        System.out.println("Printing basic type as string : "+d_object.toString()); // toString() is called explicitly



    }

}
