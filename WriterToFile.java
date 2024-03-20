package Intermediate_certification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterToFile extends PersonData {

    public WriterToFile(){}

    public StringBuilder createStringBuilder (Map<String, String> map){

        StringBuilder sb = new StringBuilder();

        sb.append("<").append(map.get("surname")).deleteCharAt(sb.length()-1).append(">");
        sb.append("<").append(map.get("name")).deleteCharAt(sb.length()-1).append(">");
        sb.append("<").append(map.get("midName")).append(">");
        sb.append("<").append(map.get("birthDate")).append(">");
        sb.append("<").append(map.get("fone")).append(">");
        sb.append("<").append(map.get("gender")).append(">").append("\n");

        return sb;
    }

    public String getPath (Map<String, String> map){
        String path = new String(map.get("surname").substring(0, map.get("surname").length()-1) + ".txt");
        return path;
    }

    public void writeToFile (StringBuilder sb, String path)throws IOException{
        FileWriter writer = new FileWriter(new File(path), true);
        try {
        writer.write(String.valueOf(sb));
        writer.write("\n");
        writer.flush();
        writer.close();
        }catch (IOException e){
            System.out.println("Нудалось сделать запись в файл.");
        }
    }
}
