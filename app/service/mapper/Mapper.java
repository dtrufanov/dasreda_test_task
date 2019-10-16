package service.mapper;

import model.Entity;

import java.util.List;

public interface Mapper<E extends Entity> {
    List<E> getAll();
    E get(Long id);
    void create(E model);
    void update(E model);
    int delete(Long id);
}
