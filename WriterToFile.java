package Intermediate_certification;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterToFile {

    public WriterToFile(){}

    public StringBuilder createStringBuilder (Map<String, String> map){

        StringBuilder sb = new StringBuilder();
        try {
        sb.append("<").append(map.get("surname")).append(">");
        sb.append("<").append(map.get("name")).append(">");
        sb.append("<").append(map.get("midName")).append(">");
        sb.append("<").append(map.get("birthDate")).append(">");
        sb.append("<").append(map.get("fone")).append(">");
        sb.append("<").append(map.get("gender")).append(">").append("\n");
        } catch (IllegalArgumentException e){
            e.getMessage();
        }
        return sb;
    }

    public String getPath (Map<String, String> map){
        String path = new String(map.get("surname") + ".txt");
        return path;
    }

    public void writeToFile (StringBuilder sb, String path)throws IOException{
        FileWriter writer = new FileWriter(new File(path), true);
        try {
        writer.write(String.valueOf(sb));
        writer.write("\n");
        writer.flush();
        writer.close();
        System.out.println("Новая запись успешно добавлена в файл " + path);
        }catch (IOException e){
            System.out.println("Нудалось сделать запись в файл.");
        }
    }
}
