package Intermediate_certification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) throws IOException {        
                
            PersonData data = new PersonData();
            String[] splitedData = {}; 
            try{
                splitedData = data.getPersonData(data.getValue());          
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            Map<String, String> mapData = new HashMap<>(data.sortDataByType(splitedData));
            for (Map.Entry<String, String> key : mapData.entrySet()) {
                System.out.println( key );
            }
            WriterToFile writer = new WriterToFile();
            String path = new String(mapData.get("surname").substring(0, mapData.get("surname").length()-1) + ".txt");
            System.out.println(path);
            
            writer.writeToFile(writer.createStringBuilder(mapData), path);
        
        
    }
}
