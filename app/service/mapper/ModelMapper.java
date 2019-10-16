package service.mapper;

import model.Model;

import java.util.List;

public interface ModelMapper extends Mapper<Model> {
    List<Model> getAll();
    Model get(Long id);
    void create(Model model);
    void update(Model model);
    int delete(Long id);
}

