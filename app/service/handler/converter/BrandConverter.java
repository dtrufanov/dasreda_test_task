package service.handler.converter;

import model.Brand;
import model.to.BrandTO;

public class BrandConverter extends Converter<Brand, BrandTO> {

    @Override
    public Brand toEntity(BrandTO to) {
        Brand brand = new Brand();
        brand.setId(to.getId());
        brand.setName(to.getName());
        brand.setCountry(to.getCountry());
        return brand;
    }

    @Override
    public BrandTO toTO(Brand brand) {
        BrandTO to = new BrandTO();
        to.setId(brand.getId());
        to.setName(brand.getName());
        to.setCountry(brand.getCountry());
        return to;
    }
}
