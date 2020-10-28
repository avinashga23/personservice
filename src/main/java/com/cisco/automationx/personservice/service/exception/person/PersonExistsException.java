package com.cisco.automationx.personservice.service.exception.person;

public class PersonExistsException extends PersonException {

    public PersonExistsException(Object... arguments) {
        super(PersonErrorCode.PERSON_EXISTS, arguments);
    }

}
