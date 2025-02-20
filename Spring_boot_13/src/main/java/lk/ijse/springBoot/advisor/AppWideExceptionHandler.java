package lk.ijse.springBoot.advisor;

import lk.ijse.springBoot.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Response exceptionHandler(Exception e) {
        return new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
    }
}
