package Intermediate_certification;

public class Program {
    public static void main(String[] args) {
        
        PersonData data = new PersonData();
        String[] newData = new String[6]; 
        try{
            newData = data.getPersonData(data.getValue());          
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
