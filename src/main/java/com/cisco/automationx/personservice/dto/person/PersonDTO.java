package com.cisco.automationx.personservice.dto.person;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO {

    private int id;

    private String name;

    private String email;

    private Date dob;

    private GenderDTO gender;

}
