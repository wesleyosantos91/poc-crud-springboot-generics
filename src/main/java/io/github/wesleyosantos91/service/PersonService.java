package io.github.wesleyosantos91.service;

import io.github.wesleyosantos91.domain.entity.Person;
import io.github.wesleyosantos91.domain.request.PersonRequest;
import io.github.wesleyosantos91.domain.response.PersonResponse;
import io.github.wesleyosantos91.mapper.PersonMapper;
import io.github.wesleyosantos91.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends AbstractService<Person, PersonResponse, PersonRequest, Long, PersonMapper, PersonRepository> {


    public PersonService(PersonRepository repository, PersonMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public List<PersonResponse> findAll() {
        return super.findAll();
    }
}
