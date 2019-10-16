package service.handler;

import model.Brand;
import model.to.BrandTO;
import play.libs.concurrent.HttpExecutionContext;
import service.repository.BrandRepository;

import javax.inject.Inject;

public class BrandTOHandler extends TOHandler<Brand, BrandTO> {

    @Inject
    public BrandTOHandler(BrandRepository brandRepository, HttpExecutionContext ec) {
        this.repository = brandRepository;
        this.ec = ec;
    }

    @Override
    protected Brand toEntity(BrandTO to) {
        Brand brand = new Brand();
        brand.setId(to.getId());
        brand.setName(to.getName());
        brand.setCountry(to.getCountry());
        return brand;
    }

    @Override
    protected BrandTO toTO(Brand brand) {
        BrandTO to = new BrandTO();
        to.setId(brand.getId());
        to.setName(brand.getName());
        to.setCountry(brand.getCountry());
        return to;
    }

}
