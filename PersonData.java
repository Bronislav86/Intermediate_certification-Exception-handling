package Intermediate_certification;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonData {

    public PersonData(){
    }

    public String getValue() throws NumberFormatException {
        Scanner inner = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения, номер телефона и пол.\n");
        String input = inner.nextLine();
        inner.close();
        return input;
    }

    public String[] getPersonData(String value) throws NumberFormatException {
        String[] data = value.split(" ");
        checkData(data);
        //print(data);
        return data;
    }

    public void checkData(String[] data) throws NumberFormatException{
        if (data.length < 6) {
            throw new NumberFormatException("Вы ввели недостаточно данных!");
        } else if (data.length > 6) {
            throw new NumberFormatException("Вы ввели лишние данные!");
        }
    }

    public Map<String, String> sortDataByType (String[] split) throws DateFormatException, FoneFormatException, GenderFormatException, NameFormatException {

        Map<String, String> mapData = new HashMap<>();
        for (String element : split) {
            if (element.contains(".") && element.length() == 10) {
                mapData.put("birthDate", element);
            }else if (element.matches(".*\\d.*"))  {
                mapData.put("fone", element);
            }else if (element.length() == 1 && (element.contains("f") || element.contains("m"))) {
                mapData.put("gender", element);
            }else if (element.contains(",") && !mapData.containsKey("surname")) {
                mapData.put("surname", element);
                if (element.contains(",") && !mapData.containsKey("name")) {
                mapData.put("name", element);
                    if (element.length() > 1 && !element.contains(".") && !element.matches(".*\\d.*") && !element.contains(",")) {
                mapData.put("midName", element);
                    }
                }
            }
        }
        return mapData;
    }
   
}


