package com.emrednmz.exception;

public class BaseException extends RuntimeException {
    public BaseException(ErrorMesaage errorMesaage) {
        super(errorMesaage.prepareErrorMessage());
    }
}
