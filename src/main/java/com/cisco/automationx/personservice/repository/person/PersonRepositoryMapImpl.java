package com.cisco.automationx.personservice.repository.person;

import com.cisco.automationx.personservice.data.person.PersonDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryMapImpl implements PersonRepository {

    private ConcurrentHashMap<Integer, PersonDO> peopleMap = new ConcurrentHashMap<>();

    private AtomicInteger idCounter = new AtomicInteger();

    @Override
    public PersonDO getById(int id) {
        return peopleMap.get(id);
    }

    @Override
    public List<PersonDO> getAll() {
        return peopleMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean exists(int id) {
        return peopleMap.containsKey(id);
    }

    @Override
    public PersonDO create(PersonDO person) {
        person.setId(idCounter.incrementAndGet());

        peopleMap.put(person.getId(), person);
        return person;
    }

    @Override
    public PersonDO update(int id, PersonDO person) {
        person.setId(id);

        peopleMap.put(id, person);
        return person;
    }

    @Override
    public void delete(int id) {
        peopleMap.remove(id);
    }
}
