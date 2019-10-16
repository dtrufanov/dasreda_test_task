package controllers;

import model.to.BrandTO;
import play.libs.concurrent.HttpExecutionContext;
import service.handler.BrandTOHandler;

import javax.inject.Inject;

public class BrandController extends CommonController<BrandTO> {

    @Inject
    public BrandController(HttpExecutionContext ec, BrandTOHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

    @Override
    protected Class<BrandTO> getTOClass() {
        return BrandTO.class;
    }
}
