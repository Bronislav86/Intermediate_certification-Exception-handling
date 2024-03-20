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
            for (Map.Entry<String, String> elem : mapData.entrySet()) {
                System.out.println( elem );
            }
            data.checkValueOfData(mapData);
            WriterToFile writer = new WriterToFile();
            String path = new String(writer.getPath(mapData));
            System.out.println(path);
            
            writer.writeToFile(writer.createStringBuilder(mapData), path);
    }
}
