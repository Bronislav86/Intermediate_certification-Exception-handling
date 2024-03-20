package Intermediate_certification;

public class GenderFormatException extends NumberFormatException {
    public GenderFormatException (){
        super("Ошибка ввода. Для ввода используйте только символы 'f' или 'm'.");
    }
}
