
package edaduser;


import java.time.Year;


/**
 *
 * @author ellui
 */
public class EdadUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //test date
        Age_Con("1995");
    }
    
    
    public static String Age_Con(String anyo) {
        try{
            //first i try to convert the variable anyo to an integer 
            //to ensure that is a number
        int a=Integer.parseInt(anyo);
        }catch(Exception e){
              throw new RuntimeException("Error: the number format introduced is incorrect");
        }
        //is verified that number atached is major than 0
        if(Integer.parseInt(anyo)<0){  throw new RuntimeException("Error:the number introduced is negative and it's not valid"); }
        // is verified that is a congruent date
        if(Integer.parseInt(anyo)-Year.now().getValue()>120 || Integer.parseInt(anyo)>Year.now().getValue() ){  throw new RuntimeException("Error: The date that you enter is incorrect, please correct your date"); }
      
        //if all is correct the function return your age
        return String.valueOf(Year.now().getValue()-Integer.parseInt(anyo));
        
    }


    

}
    

