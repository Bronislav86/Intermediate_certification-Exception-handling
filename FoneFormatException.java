package Intermediate_certification;

public class FoneFormatException extends NumberFormatException {
    public FoneFormatException(){
        super("Номер телефона введен неверно. Используйте пожалуйста для ввода только цифры.");
    }
}
