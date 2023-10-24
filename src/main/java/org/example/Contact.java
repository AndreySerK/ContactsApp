package org.example;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @NotNull
    private String fullName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @Override
    public String toString() {
        return fullName + " | " + phoneNumber + " | " + email;
    }
}
