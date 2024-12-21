package model.exceptions;

//Exception o compilador vai obrigar a tratar com try catch, RuntimeExcepction não vai obrigar
public class DomainException extends Exception {
    public DomainException(String msg) {
        super(msg);
    }
}
