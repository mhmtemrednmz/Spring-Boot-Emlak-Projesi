package com.emrednmz.exception.handler;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
public class Exception <E>{

    private String path;
    private Date timestamp;
    private String hostname;
    private E message;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public E getMessage() {
        return message;
    }

    public void setMessage(E message) {
        this.message = message;
    }
}
