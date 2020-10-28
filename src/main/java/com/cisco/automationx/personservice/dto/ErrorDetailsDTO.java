package com.cisco.automationx.personservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetailsDTO {

    private Date timestamp;

    private String error;

    private String message;

}
