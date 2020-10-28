package com.cisco.automationx.personservice.controller.person;

import com.cisco.automationx.personservice.bo.person.PersonBO;
import com.cisco.automationx.personservice.dto.person.PersonDTO;
import com.cisco.automationx.personservice.service.person.PersonService;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    private final Mapper mapper;

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable int id) {
        return mapper.map(personService.getById(id), PersonDTO.class);
    }

    @GetMapping("/")
    public List<PersonDTO> getAll() {
        return personService.getAll().stream().map(personBO -> mapper.map(personBO, PersonDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/")
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return mapper.map(personService.create(mapper.map(personDTO, PersonBO.class)), PersonDTO.class);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable("id") int id, @RequestBody PersonDTO personDTO) {
        return mapper.map(personService.update(id, mapper.map(personDTO, PersonBO.class)), PersonDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        personService.delete(id);
    }
}
