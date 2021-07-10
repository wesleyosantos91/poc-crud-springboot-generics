package io.github.wesleyosantos91.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public interface AbstractMapper<D, T, I> {

    T parseResponse(D d);
    D parseDomain(I i);

    default List<T> parserToListResponse(List<D> domains){
        List<T> list = new ArrayList<>();
        domains.forEach(d-> list.add(parseResponse(d)));
        return list;
    }

    default Page<T> parserToPageResponse(Page<D> pages){
        List<T> list = parserToListResponse(pages.getContent());
        return new PageImpl<>(list, pages.getPageable(), pages.getTotalElements());

    }
}
