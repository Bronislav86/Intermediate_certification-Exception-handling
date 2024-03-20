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
                if (!element.contains(".")) {
                    throw new DateFormatException();
                }
            }
            if (element.matches(".*\\d.*"))  {
                mapData.put("fone", element);
            }else if (element.length() == 1 && (element.contains("f") || element.contains("m"))) {
                mapData.put("gender", element);
            }else if (element.length() > 1 && !element.matches(".*\\d.*") && !mapData.containsKey("surname")) {
                mapData.put("surname", element);
            }else if (element.length() > 1 && !element.matches(".*\\d.*") && mapData.containsKey("surname") && !mapData.containsKey("name")) {
                mapData.put("name", element);
            }else if (element.length() > 1 && !element.matches(".*\\d.*") && mapData.containsKey("surname") && mapData.containsKey("name") && !mapData.containsKey("midName")) {
                mapData.put("midName", element);
            }
        }
        return mapData;
    }

    public void checkValueOfData (Map<String, String> map){

        if (!map.containsKey("birthDate")) {
            throw new DateFormatException();
        } else if (!map.containsKey("fone")) {
            throw new FoneFormatException();
        }else if (!map.containsKey("gender")) {
            throw new GenderFormatException();
        } else if (!map.containsKey("surname")) {
            throw new NameFormatException();
        } else if (!map.containsKey("name")) {
            throw new NameFormatException();
        }else if (!map.containsKey("midName")) {
            throw new NameFormatException();
        }
    }
   
}


