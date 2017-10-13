package readjson;

import org.json.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\ellui\\Desktop\\prueba.json"));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        String json = fileData.toString();

        String json2 = json.replace("{", "");
        String json3 = json2.replace("}", "");
        String json4 = json3.replace("\"", "");
        String json5 = json4.replace(" ", "");
        String json6 = json5.replace("children:", "");
        String json7 = json6.replace("dob:", "");
        
        String[] partes = json7.split(",");
        
       
        int auxMen=78888878;
        int auxMay=0;
        String resultado="Names: ";
         for (int i=0;i<partes.length;i++){
             if(i==partes.length-1){
          resultado=resultado+""+partes[i].replaceAll("[\\n\\r]","").replace("\t","").split(":")[0]+".";
             }
             else{
                 resultado=resultado+partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[0] + ",";
             }
             
        
             if(auxMen>Integer.parseInt(partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[1])){
                 auxMen=Integer.parseInt(partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[1]);
             }
             
              if(auxMay<Integer.parseInt(partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[1])){
                 auxMay=Integer.parseInt(partes[i].replaceAll("[\\n\\r]", "").replace("\t", "").split(":")[1]);
             }
         }
         
         resultado=resultado+"\nOldest: "+auxMen+", Recent: "+auxMay;
         System.out.println(resultado);
    

    }

}
