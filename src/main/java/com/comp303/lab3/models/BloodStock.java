package com.comp303.lab3.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BloodStock {
    private int id;

    private String bloodGroup;

    private int quantity;

    private Date bestBefore;

    private boolean status;
}
