package io.github.wesleyosantos91.service;

import io.github.wesleyosantos91.exception.core.ObjectNotFoundException;
import io.github.wesleyosantos91.mapper.AbstractMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.String.format;

@AllArgsConstructor
public abstract class AbstractService<D, T, I, ID, M extends AbstractMapper<D, T, I>, R extends JpaRepository<D, ID>> {

    protected R repository;
    protected M mapper;

    public List<T> findAll(){
        final List<D> list = this.repository.findAll();
        return mapper.parserToListResponse(list);
    }

    public Page<T> findAllPage(Pageable pageable) {
        final Page<D> pages = repository.findAll(pageable);
        return mapper.parserToPageResponse(pages);
    }

    public T findById(ID id){
        return mapper.parseResponse(exist(id));
    }

    @Transactional
    public T save(I i) throws Exception {
        D domain = mapper.parseDomain(i);
        domain = this.repository.save(domain);
        return mapper.parseResponse(domain);
    }

    @Transactional
    public T update(ID id, I i) throws Exception {
        D d = exist(id);
        BeanUtils.copyProperties(i, d, "id");
        d = this.repository.save(d);
        return mapper.parseResponse(d);
    }

    @Transactional
    public void delete(ID id) {
        D d = exist(id);
        repository.delete(d);
    }

    private D exist(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(format("Not found regitstry with code %d", id)));
    }

}
