package com.cisco.automationx.personservice.repository.person;

import com.cisco.automationx.personservice.data.person.PersonDO;

import java.util.List;

public interface PersonRepository {

    PersonDO getById(int id);

    List<PersonDO> getAll();

    boolean exists(int id);

    PersonDO create(PersonDO person);

    PersonDO update(int id, PersonDO person);

    void delete(int id);

}
