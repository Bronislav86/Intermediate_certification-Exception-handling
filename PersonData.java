package Intermediate_certification;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonData {

    public PersonData(){
    }

    public String getValue() throws NumberFormatException {
        Scanner inner = new Scanner(System.in);
        System.out.println("Введите персональные данные, используя заданный формат в одну строку в любом порядке:\n");
        System.out.println("1. Фамилия Имя Отчество - через пробел");
        System.out.println("2. Дату рождения - dd.mm.yyyy");
        System.out.println("3. Номер телефона - 89xxxxxxxxx");
        System.out.println("4. Пол - 'f'-жен., 'm'-муж.");
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
            }else if (element.matches(".*\\d.*") && element.length() == 11)  {
                mapData.put("fone", element);
                if (!element.contains(".*\\d.*") && element.length() < 11) {
                    throw new FoneFormatException();
                }
            }else if (element.length() == 1 && (element.contains("f") || element.contains("m"))) {
                mapData.put("gender", element);
                if (element.length() != 1 && (!element.contains("f") || !element.contains("m"))) {
                    throw new GenderFormatException();
                }
            }else if (element.length() > 1 && !element.matches(".*\\d.*") && !mapData.containsKey("surname")) {
                mapData.put("surname", element);
                if (element.contains(".*\\d.*") || element.contains(".") || element.length() < 2) {
                    throw new NameFormatException();
                }
            }else if (element.length() > 1 && !element.matches(".*\\d.*") && mapData.containsKey("surname") && !mapData.containsKey("name")) {
                mapData.put("name", element);
                if (element.contains(".*\\d.*") || element.contains(".") || element.length() < 2) {
                    throw new NameFormatException();
                }
            }else if (element.length() > 1 && !element.matches(".*\\d.*") && mapData.containsKey("surname") && mapData.containsKey("name") && !mapData.containsKey("midName")) {
                mapData.put("midName", element);
                if (element.contains(".*\\d.*") || element.contains(".") || element.length() < 2) {
                    throw new NameFormatException();
                }
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


