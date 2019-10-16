package controllers;

import model.to.ModelTO;
import play.libs.concurrent.HttpExecutionContext;
import service.handler.ModelTOHandler;

import javax.inject.Inject;

public class ModelController extends CommonController<ModelTO> {

    @Inject
    public ModelController(HttpExecutionContext ec, ModelTOHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

    @Override
    protected Class<ModelTO> getTOClass() {
        return ModelTO.class;
    }

}
