package Intermediate_certification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        
        PersonData data = new PersonData();
        String[] splitedData = new String[6]; 
        try{
            splitedData = data.getPersonData(data.getValue());          
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        FileWriter writer;
        StringBuilder dataToWrite = new StringBuilder();
        String path = splitedData[0] + ".txt";
        if (!path.equals(splitedData[0] + ".txt")) {       
            try {
                writer = new FileWriter(path);
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
            for (String element : sb) {
                dataToWrite.append(element);
            }
            dataToWrite.delete(dataToWrite.length(), dataToWrite.length()).append("\n");
            writer = new FileWriter(path);
            writer.write(String.valueOf(dataToWrite) + "\n");
            writer.write("\n");
            writer.flush();
            writer.close();
        }
        

    }
}
