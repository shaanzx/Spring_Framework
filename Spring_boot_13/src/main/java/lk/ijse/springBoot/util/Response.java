package lk.ijse.springBoot.util;

public class Response {
    private String message;
    private boolean success;
    private Object data;

    public Response(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public Response(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
