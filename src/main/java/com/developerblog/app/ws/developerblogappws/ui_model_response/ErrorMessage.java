package com.developerblog.app.ws.developerblogappws.ui_model_response;

import java.util.Date;

public class ErrorMessage {
    private Date timeStamp;
    private String message;

    public ErrorMessage() {

    }

    public ErrorMessage(Date timeStamp, String meseage) {
        super();
        this.timeStamp = timeStamp;
        this.message = meseage;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMessage [message=" + message + ", timeStamp=" + timeStamp + "]";
    }

}