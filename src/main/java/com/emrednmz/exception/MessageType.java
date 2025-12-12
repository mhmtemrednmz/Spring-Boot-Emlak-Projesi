package com.emrednmz.exception;


public enum MessageType {

    NO_RECORD_EXIST("1004", "Kayıt Bulunamadı"),
    TOKEN_IS_NOT_VALID("1005","Token Süresi Bitmiştir"),
    NOT_FOUND_USERNAME("1006","Username Bulunamadı"),
    EMAIL_OR_PASSWORD_INCORRECT("1007","Email Ya da Parola Hatalı"),
    NOT_FOUND_REFRESH_TOKEN("1008","Refresh Token Bulunamadı"),
    NOT_FOUND_ADDRESS("1009","Adres Bulunamadı"),
    NOT_FOUND_USER("1010","Kullanıcı Bulunamadı"),
    NOT_FOUND_ADVERT("1011","İlan Bulunamadı"),
    NOT_FOUND_FAVORITE("1012","Favori Bulunamadı"),
    NOT_FOUND_IMAGES("1012","Resim Bulunamadı"),
    NOT_FOUND_MESSAGE("1013","Mesaj Bulunamadı"),
    GENERAL_EXCEPTION("9999","Genel Bir Hata Oluştu");


    private String code;
    private String message;
    private MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
