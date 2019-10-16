package service.repository;

import model.Brand;
import service.execution.BrandExecutionContext;
import service.mapper.BrandMapper;

import javax.inject.Inject;

public class BrandRepository extends Repository<Brand> {

    @Inject
    public BrandRepository(BrandMapper brandMapper, BrandExecutionContext ec) {
        this.mapper = brandMapper;
        this.ec = ec;
    }
}
