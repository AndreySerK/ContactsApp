package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private String fullName;

    private String phoneNumber;

    private String email;

    @Override
    public String toString() {
        return fullName + " | " + phoneNumber + " | " + email;
    }
}
