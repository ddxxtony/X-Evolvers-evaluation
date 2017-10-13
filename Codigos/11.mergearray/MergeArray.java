
package mergearray;

/**
 *
 * @author ellui
 */
public class MergeArray {

 
    public static void main(String[] args) {
        //we declare our variables
        int[] arr1 = {4, 5, 7, 9, 10, 34};
        int[] arr2 = {1, 3, 6, 8, 32, 33};
        // call to the function
        merge(arr1, arr2); // returns
    }

    public static int[] merge(int[] a, int[] b) {
        //this vector will save the union of a and b
        int[] result = new int[a.length + b.length];
        //this varables will help us to move  within vectors a and b
        int i = 0;// a vector
        int j = 0;// b vecetor
        int index = 0;// index for the resultant vector
            //here a cicle is declared and ends when all the elements of the two vectors are asssigned
            //to the new one.
        for (int p = 0; p < result.length; p++) {
            // if the two vectors still have a items that havn't been added to the new vector 
            //a comparison is maked to check wich value must be the next to add to the new vector
            //if the value is added from vector a the variable i is incremented one value.
            //if the value is added from vector b the variable j is incremented one value.
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    result[index] = a[i];
                    i++;
                } else {
                    result[index] = b[j];
                    j++;
                }
               
            }//if somethin of the vectors no longer has  values to add to the new vector then 
            // both are checked to try to find  which of they still have items to add.\
            
            else if (i < a.length) { 
                result[index] = a[i];
                i++;
            } else if (j < b.length) {
                result[index] = b[j];
                j++;
            }
            //the index is incremented on each iteration
             index++;
        }

        return result;
    }

}
