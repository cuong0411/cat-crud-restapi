package org.cuong.catcrudrestapi.exception;

public class CatNotFoundException extends RuntimeException{
    
    public CatNotFoundException() {
        super();
    }

    public CatNotFoundException(String message) {
        super(message);
    }
}
