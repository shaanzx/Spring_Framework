package lk.ijse.spring_boot_bean_validation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must be at least 3 characters long")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters long")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits long")
    private String phoneNo;
}
