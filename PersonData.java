package Intermediate_certification;

import java.util.Scanner;

public class PersonData {

    public PersonData(){
    }

    public String getValue() throws NumberFormatException {
        Scanner inner = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения, номер телефона и пол.\n");
        String input = inner.nextLine();
        return input;
    }

    public String[] getPersonData(String value) throws NumberFormatException {
        String[] data = value.split(" ");
        checkData(data);
        print(data);
        return data;
    }

    private void print(String[] c){
        for (String string : c) {
            System.out.println(string);
        }
    }

    public void checkData(String[] data) throws NumberFormatException{
        if (data.length < 6) {
            throw new NumberFormatException("Вы ввели недостаточно данных!");
        } else if (data.length > 6) {
            throw new NumberFormatException("Вы ввели лишние данные!");
        }
    }
   
}


