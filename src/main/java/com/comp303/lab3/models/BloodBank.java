package com.comp303.lab3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BloodBank {
    private int id;

    private String name;

    private String address;

    private String city;

    private int phoneNumber;

    private String website;

    private String email;
}
