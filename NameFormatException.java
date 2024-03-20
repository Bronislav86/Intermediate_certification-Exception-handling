package Intermediate_certification;

public class NameFormatException extends NumberFormatException {
    public NameFormatException(){
        super("Ошибка ввода имени! Для ввода Ф.И.О. используйте пожалуйста только буквы");
    }
}
