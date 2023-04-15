package com.comp303.lab3.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
    private int id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Min(value = 0, message = "Age should be equal/greater than zero")
    private int age;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @NotBlank(message = "Blood Group is mandatory")
    private String bloodGroup;

    @NotBlank(message = "City is mandatory")
    private String city;

    @Min(value = 0, message = "Phone Number should be equal/greater than zero")
    private int phoneNumber;
}
