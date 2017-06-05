package ua.lviv.lgs.exceptions;

/**
 * Created by Артем on 5/7/2017.
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
