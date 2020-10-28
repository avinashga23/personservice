package com.cisco.automationx.personservice.data.person;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDO {

    private int id;

    private String name;

    private String email;

    private Date dob;

    private GenderDO gender;

}
