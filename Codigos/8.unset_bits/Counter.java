/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter;

public class Counter {

 
    public static void main(String[] args) {
        //test number1
        int numero = 12547;
        System.out.println(cuenta(numero));
        //test number2 
        int numero2 = 65535;
        System.out.println(cuenta(numero2));
    }

    public static int cuenta(int number) {
        //counter for unset bits
        int count = 0;
        
        //displace one bit per cicle 
        for (int i = 0; i < 15; i++) {
            //i use  an and operation 
            if ((number & 1) == 0) {
                count++;
            }
            //displace one bit
            number = number >>>1;
        }
        //result is returned
        return (count == 0) ? 0 : count + 1;
    }

}
