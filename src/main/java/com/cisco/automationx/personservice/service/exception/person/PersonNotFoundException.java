package com.cisco.automationx.personservice.service.exception.person;

public class PersonNotFoundException extends PersonException {

    public PersonNotFoundException(Object... arguments) {
        super(PersonErrorCode.PERSON_BY_ID_NOT_FOUND, arguments);
    }
}
