package service;

public class ComicServiceException extends RuntimeException {
    public ComicServiceException() {
        super();
    }

    public ComicServiceException(String msg) {
        super(msg);
    }
}
