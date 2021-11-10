package quixada.npi.springproject.exception;

public class DataIntegrityException extends RuntimeException{
    public DataIntegrityException(String msg){
        super(msg);
    }
}
