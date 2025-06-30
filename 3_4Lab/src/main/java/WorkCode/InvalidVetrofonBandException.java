package WorkCode;

public class InvalidVetrofonBandException extends Exception {

    public InvalidVetrofonBandException(String message) 
    {
        super(message);
    }

    @Override
    public String getMessage() 
    {

        return "Ошибка -> " + super.getMessage();
        
    }
    
}
