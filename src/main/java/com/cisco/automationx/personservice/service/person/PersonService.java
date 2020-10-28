package com.cisco.automationx.personservice.service.person;

import com.cisco.automationx.personservice.bo.person.PersonBO;

import java.util.List;

public interface PersonService {

    PersonBO getById(int id);

    List<PersonBO> getAll();

    boolean exists(int id);

    PersonBO create(PersonBO personBO);

    PersonBO update(int id, PersonBO personBO);

    void delete(int id);

}
