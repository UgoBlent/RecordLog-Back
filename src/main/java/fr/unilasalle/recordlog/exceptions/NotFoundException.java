package fr.unilasalle.recordlog.exceptions;

public class NotFoundException extends Throwable {
    public NotFoundException(String message, String cause) {
        super(message, new Throwable(cause));
    }
}

