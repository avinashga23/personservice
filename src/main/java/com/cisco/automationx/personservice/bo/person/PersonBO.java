package com.cisco.automationx.personservice.bo.person;

import lombok.Data;

import java.util.Date;

@Data
public class PersonBO {

    private int id;

    private String name;

    private String email;

    private Date dob;

    private GenderBO gender;

}
