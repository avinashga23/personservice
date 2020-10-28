package com.cisco.automationx.personservice.service.exception.person;

public enum PersonErrorCode {
    PERSON_BY_ID_NOT_FOUND("person.byid.notfound"), PERSON_EXISTS("person.exists");

    private final String code;

    private PersonErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
