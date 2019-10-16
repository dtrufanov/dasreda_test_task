package service.mapper;

import model.Brand;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    List<Brand> getAll();
    Brand get(Long id);
    void create(Brand brand);
    void update(Brand brand);
    int delete(Long id);
}
