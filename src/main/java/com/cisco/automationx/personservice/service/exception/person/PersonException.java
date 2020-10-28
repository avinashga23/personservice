package com.cisco.automationx.personservice.service.exception.person;

public class PersonException extends RuntimeException {

    private final PersonErrorCode errorCode;

    private final Object[] arguments;

    public PersonException(PersonErrorCode errorCode, Object... arguments) {
        this.errorCode = errorCode;
        this.arguments = arguments;
    }

    public String getErrorCode() {
        return errorCode.getCode();
    }

    public Object[] getArguments() {
        return arguments;
    }
}
