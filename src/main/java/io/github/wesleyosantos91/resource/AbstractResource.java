package io.github.wesleyosantos91.resource;

import io.github.wesleyosantos91.mapper.AbstractMapper;
import io.github.wesleyosantos91.service.AbstractService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
public class AbstractResource<D, T, I, ID, M extends AbstractMapper<D, T, I>, R extends JpaRepository<D, ID>, S extends  AbstractService<D, T, I, ID, M, R>> {

    protected S service;

    @PostMapping
    public ResponseEntity<T> create(@RequestBody I i) throws Exception {

        var response = service.save(i);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> findByCode(@PathVariable ID id) {
        var response = service.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<Page<T>>findAllPage(
            @PageableDefault(sort = "id",
                    direction = Sort.Direction.ASC,
                    page = 0,
                    size = 10) Pageable page) {

        var pages = service.findAllPage(page);
        return ResponseEntity.ok().body(pages);
    }

    @GetMapping(value ="/all")
    public ResponseEntity<List<T>> findAll() {

        var persons = service.findAll();
        return ResponseEntity.ok().body(persons);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody I i) throws Exception {

        var response = service.update(id, i);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
