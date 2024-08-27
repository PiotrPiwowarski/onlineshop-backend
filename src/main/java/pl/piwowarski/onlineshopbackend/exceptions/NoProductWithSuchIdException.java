package pl.piwowarski.onlineshopbackend.exceptions;


public class NoProductWithSuchIdException extends RuntimeException{

    private final String message;

    public NoProductWithSuchIdException() {
        message = "Brak produktów o podanym id";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
