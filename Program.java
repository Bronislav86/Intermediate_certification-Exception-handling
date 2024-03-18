package Intermediate_certification;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Program {
    public static void main(String[] args) throws IOException {
        
        PersonData data = new PersonData();
        String[] splitedData = new String[6]; 
        try{
            splitedData = data.getPersonData(data.getValue());          
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        Map<String, String> mapData = new HashMap<>();
        for (String element : splitedData) {
            if (element.contains(".") && element.length() == 10) {
                mapData.put("birthDate", element);
            } else if (element.matches(".*\\d.*"))  {
                mapData.put("fone", element);
            } else if (element.length() == 1 && (element.contains("f") || element.contains("m"))) {
                mapData.put("gender", element);
            }else if (element.contains(",") && !mapData.containsKey("surname")) {
                mapData.put("surname", element);
            } else if (element.contains(",") && !mapData.containsKey("name")) {
                mapData.put("name", element);
            }else if (element.length() > 1 && !element.contains(".") && !element.matches(".*\\d.*") && !element.contains(",")) {
                mapData.put("midName", element);
            }      
        }

        for (Map.Entry<String,String> string : mapData.entrySet()) {
            System.out.println(string.getKey() + "=" + string.getValue());
        }
        
        StringBuilder dataToWrite = new StringBuilder();
        String path = mapData.get("surname").substring(0, mapData.get("surname").length()-1) + ".txt";
        FileWriter writer = new FileWriter(new File(path), true);
            try {

                dataToWrite.append("<").append(mapData.get("surname")).deleteCharAt(dataToWrite.length()-1).append(">");
                dataToWrite.append("<").append(mapData.get("name")).deleteCharAt(dataToWrite.length()-1).append(">");
                dataToWrite.append("<").append(mapData.get("midName")).append(">");
                dataToWrite.append("<").append(mapData.get("birthDate")).append(">");
                dataToWrite.append("<").append(mapData.get("fone")).append(">");
                dataToWrite.append("<").append(mapData.get("gender")).append(">").append("\n");
            System.out.println(dataToWrite);
            writer.write(String.valueOf(dataToWrite));
            writer.write("\n");
            writer.flush();
            writer.close();
            }catch (IOException e){
                System.out.println("Нудалось записать в файл.");
            }
        // } else {
        //     for (String string : splitedData) {
        //         dataToWrite.append(string).append(" ");
        //     }
        //     dataToWrite.delete(dataToWrite.length(), dataToWrite.length()).append("\n");
        //     BufferedReader br = new BufferedReader(new FileReader(path));
        //     List<String> sb = new ArrayList<>();
        //     String content = br.readLine();
        //     while (content != null) {
        //         sb.add(content);
        //         content = br.readLine();
        //     }
        //     br.close();
        //     dataToWrite.append("\n");
        //     for (String element : sb) {
        //         dataToWrite.append(element);
        //     }
        //     dataToWrite.delete(dataToWrite.length(), dataToWrite.length()).append("\n");
        //     writer.write(String.valueOf(dataToWrite) + "\n");
        //     writer.write("\n");
        //     writer.flush();
        //     writer.close();
        // }
        

    }
}
