package readjson;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        read_json("prueba.json");

    

    }
    
    public static String  read_json(String path){
            //here i read the json file
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(path));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        //pass the file to a string
        String json = fileData.toString();

      //i decided to work with the file not as json because 
        // the requirements for the problem also can be  realized  working as a  simple 
        ///text file , only i need to prepare the json and remove some things.
//      ///at the end I will have a pair of values name-birth separed by colon and each
        //of this pair of values separed by a comma, then will be easy accomplish the objectives of the problem.

        //here i remove the "trash"
        String json2 = json.replace("{", "");
        String json3 = json2.replace("}", "");
        String json4 = json3.replace("\"", "");
        String json5 = json4.replace(" ", "");
        String json6 = json5.replace("children:", "");
        String json7 = json6.replace("dob:", "");
        
        //here i create a array of pair of values name-birth;
        String[] partes = json7.split(",");
        
       //this variables are used to look up the oldest and the recent bitrhs
        int auxMen=78888878;
        int auxMay=0;
        
        //here the result will be saved
        String resultado="Names: ";
        
        //here I traverse the array of pair of values name-birth;
         for (int i=0;i<partes.length;i++){
             
        // with this conditional I add all the names separated by comma when the 
             // last register is reached i add a point at the end.
             if(i==partes.length-1){
          resultado=resultado+""+partes[i].replaceAll("[\\n\\r]","").replace("\t","").split(":")[0]+".";
             }
             else{
                 resultado=resultado+partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[0] + ",";
             }
             
       // here we are looking for the oldest and the recent bitrhs
             if(auxMen>Integer.parseInt(partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[1])){
                 auxMen=Integer.parseInt(partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[1]);
             }
             
              if(auxMay<Integer.parseInt(partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[1])){
                 auxMay=Integer.parseInt(partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[1]);
             }
         }
         
        
        //at the end we only add the oldest and the recent birth with the appropriate format.
         resultado=resultado+"\nOldest: "+auxMen+", Recent: "+auxMay;
       return resultado;
    
    }

}
