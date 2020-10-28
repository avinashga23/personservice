package com.cisco.automationx.personservice.service.person;

import com.cisco.automationx.personservice.bo.person.PersonBO;
import com.cisco.automationx.personservice.data.person.PersonDO;
import com.cisco.automationx.personservice.repository.person.PersonRepository;
import com.cisco.automationx.personservice.service.exception.person.PersonNotFoundException;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final Mapper mapper;

    @Override
    public PersonBO getById(int id) {
        if (!exists(id))
            throw new PersonNotFoundException(id);
        return mapper.map(personRepository.getById(id), PersonBO.class);
    }

    @Override
    public List<PersonBO> getAll() {
        return personRepository.getAll().stream().map(personDO -> mapper.map(personDO, PersonBO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(int id) {
        return personRepository.exists(id);
    }

    @Override
    public PersonBO create(PersonBO personBO) {
        return mapper.map(personRepository.create(mapper.map(personBO, PersonDO.class)), PersonBO.class);
    }

    @Override
    public PersonBO update(int id, PersonBO personBO) {
        if (!exists(id))
            throw new PersonNotFoundException(id);
        return mapper.map(personRepository.update(id, mapper.map(personBO, PersonDO.class)), PersonBO.class);
    }

    @Override
    public void delete(int id) {
        personRepository.delete(id);
    }
}
