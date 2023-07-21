package com.qa.PersonProject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;

}
