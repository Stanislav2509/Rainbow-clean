package com.example.Rainbow.clean.model.dto.binding;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {
    @Size(min=3, max = 20)
    private String firstName;
    @Size(min=3, max = 20)
    private String lastName;
    @NotNull
    @Min(6)
    private String password;
    @NotNull
    @Min(6)
    private String confirmPassword;
    @NotBlank
    @Email
    private String email;
   @Size(min = 10, max = 13)
    private String gsm;
}
