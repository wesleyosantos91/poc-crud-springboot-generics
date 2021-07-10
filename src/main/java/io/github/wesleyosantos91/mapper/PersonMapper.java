package io.github.wesleyosantos91.mapper;

import io.github.wesleyosantos91.domain.entity.Person;
import io.github.wesleyosantos91.domain.request.PersonRequest;
import io.github.wesleyosantos91.domain.response.PersonResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends AbstractMapper<Person, PersonResponse, PersonRequest> {
}
