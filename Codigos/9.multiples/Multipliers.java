
import java.util.ArrayList;


public class multiples {

    public static void main(String[] args) {

       // we will declare  this list which will be used to store all
       // the numbers of which we want to find their multiple together with its string

        ArrayList<items> list = new ArrayList<items>();
        list.add(new items(3, "Fizz"));
        list.add(new items(5, "Buzz"));
        //call the fucntion 
        print_numbers(list);
    }

    public static void print_numbers(ArrayList<items> l) {
        //this will be the variable that will show the numbers between 1 and 100
        int i = 1;
        
        //the message will serve as a kind of flag 
        // because if the flag is empty then a number will be displayed
        //on the contrary will display the message that function returns
        // this message is any that is contained in the linked list some of it 
        //depends of the funciton verifica
        String msg;
        do {

            msg = verifica(l, i);
            if (msg.equals("")) {
                System.out.println(i);
            } else {
                System.out.println(msg);
            }

            i++;
        } while (i <= 100);

    }

    //here is where the magic happens
    //this function receives the linked list that contains
    //the numbers to verify if one,many or all of they are multiple of the number n
    //
    public static String verifica(ArrayList<items> l, int n) {
        //we declare an empty string
        String resul = "";
     
        //in this cicle all liked-list numbers are checked to try to find they that are multiples of n
        // each time that a multiple of n is found 
        //its message is concatenated to the string resul;
        for (int i = 0; i < l.size(); i++) {
            if (n % l.get(i).getNum() == 0) {
                resul = resul + l.get(i).getStr();
            }
        }

        return resul;
    }

}
