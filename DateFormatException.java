package Intermediate_certification;

public class DateFormatException extends NumberFormatException {
    public DateFormatException(){
        super("Дата введена неверно. Используйте пожалуйста формат dd.mm.yyyy");
    }
    
}
