package lk.ijse.spring_boot_bean_validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO {
    private String message;
    private int statusCode;
    private Object data;
}
