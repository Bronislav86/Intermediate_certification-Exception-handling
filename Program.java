package Intermediate_certification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.RowFilter.Entry;

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
            if (element.contains(".")) {
                mapData.put("birthDate", element);
            } else if (element.matches(".*\\d.*"))  {
                mapData.put("fone", element);
            } else if (element.length() == 1) {
                mapData.put("gender", element);
            }else if (element.contains(",")) {
                mapData.put("name", element);
            }            
        }
        
        StringBuilder dataToWrite = new StringBuilder();
        String path = splitedData[0].substring(0, splitedData[0].length() - 1) + ".txt";
        FileWriter writer = new FileWriter(new File(path), true);
        if (!path.equals(splitedData[0].length() - 1 + ".txt")) {       
            try {
            for (String string : splitedData) {
                dataToWrite.append(string).append(" ");
            }
            dataToWrite.delete(dataToWrite.length(), dataToWrite.length()).append("\n");
            writer.write(String.valueOf(dataToWrite));
            writer.write("\n");
            writer.flush();
            writer.close();
            }catch (IOException e){
                System.out.println("Нудалось записать в файл.");
            }
        } else {
            for (String string : splitedData) {
                dataToWrite.append(string).append(" ");
            }
            dataToWrite.delete(dataToWrite.length(), dataToWrite.length()).append("\n");
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<String> sb = new ArrayList<>();
            String content = br.readLine();
            while (content != null) {
                sb.add(content);
                content = br.readLine();
            }
            br.close();
            dataToWrite.append("\n");
            for (String element : sb) {
                dataToWrite.append(element);
            }
            dataToWrite.delete(dataToWrite.length(), dataToWrite.length()).append("\n");
            writer.write(String.valueOf(dataToWrite) + "\n");
            writer.write("\n");
            writer.flush();
            writer.close();
        }
        

    }
}
