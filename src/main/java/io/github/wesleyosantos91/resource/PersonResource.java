package io.github.wesleyosantos91.resource;

import io.github.wesleyosantos91.domain.entity.Person;
import io.github.wesleyosantos91.domain.request.PersonRequest;
import io.github.wesleyosantos91.domain.response.PersonResponse;
import io.github.wesleyosantos91.mapper.PersonMapper;
import io.github.wesleyosantos91.repository.PersonRepository;
import io.github.wesleyosantos91.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonResource extends AbstractResource<Person, PersonResponse, PersonRequest, Long, PersonMapper, PersonRepository, PersonService> {

    @Autowired
    public PersonResource(PersonService service) {
        super(service);
    }
}
