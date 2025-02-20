package lk.ijse.springBoot.util;

import org.springframework.http.HttpStatus;

public class Response {
    private String message;
    private int status;
    private Object data;

    public Response(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }

    public Response(String message, HttpStatus status, Object data) {
        this.message = message;
        this.status = status.value();
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(HttpStatus status) {
        this.status = status.value();
    }

    public void setData(Object data) {
        this.data = data;
    }
}