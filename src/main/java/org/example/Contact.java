package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @NonNull
    private String fullName;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String email;

    @Override
    public String toString() {
        return fullName + " | " + phoneNumber + " | " + email;
    }
}
