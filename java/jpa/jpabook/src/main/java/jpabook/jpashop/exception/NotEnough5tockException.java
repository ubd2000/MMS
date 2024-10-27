package jpabook.jpashop.exception;

/**
 * @author DongMin kim
 */
public class NotEnough5tockException extends RuntimeException {
    public NotEnough5tockException() {
        super();
    }

    public NotEnough5tockException(String message) {
        super(message);
    }

    public NotEnough5tockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnough5tockException(Throwable cause) {
        super(cause);
    }

    protected NotEnough5tockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
