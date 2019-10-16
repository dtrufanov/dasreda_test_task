package controllers;

import model.to.PositionTO;
import play.libs.concurrent.HttpExecutionContext;
import service.handler.PositionTOHandler;

import javax.inject.Inject;

public class PositionController extends CommonController<PositionTO> {

    @Inject
    public PositionController(HttpExecutionContext ec, PositionTOHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

    @Override
    protected Class<PositionTO> getTOClass() {
        return PositionTO.class;
    }
}
