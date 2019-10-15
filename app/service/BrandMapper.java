package service;

import model.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> getBrands();
    Brand getBrand(Long id);
    void create(Brand brand);
    void update(Brand brand);
    int delete(Long id);
}
