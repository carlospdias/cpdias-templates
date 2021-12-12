package br.com.cpdias.general.exception;

public class DataAccessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataAccessException(String msg, Throwable cause, boolean enableSupression,  boolean writbleStackTrace) {
        super(msg, cause, enableSupression, writbleStackTrace);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
