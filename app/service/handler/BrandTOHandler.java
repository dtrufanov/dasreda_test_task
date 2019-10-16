package service.handler;

import model.Brand;
import model.to.BrandTO;
import play.libs.concurrent.HttpExecutionContext;
import service.handler.converter.BrandConverter;
import service.handler.converter.Converter;
import service.repository.BrandRepository;

import javax.inject.Inject;

public class BrandTOHandler extends TOHandler<Brand, BrandTO> {
    private final BrandConverter converter = new BrandConverter();


    @Inject
    public BrandTOHandler(BrandRepository brandRepository, HttpExecutionContext ec) {
        this.repository = brandRepository;
        this.ec = ec;
    }

    @Override
    protected Converter<Brand, BrandTO> getConverter() {
        return converter;
    }
}
