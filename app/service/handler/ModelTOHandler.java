package service.handler;

import model.Model;
import model.to.ModelTO;
import play.libs.concurrent.HttpExecutionContext;
import service.handler.converter.Converter;
import service.handler.converter.ModelConverter;
import service.repository.ModelRepository;

import javax.inject.Inject;


public class ModelTOHandler extends TOHandler<Model, ModelTO> {
    private final ModelConverter converter = new ModelConverter();

    @Inject
    public ModelTOHandler(ModelRepository modelRepository, HttpExecutionContext ec) {
        this.repository = modelRepository;
        this.ec = ec;
    }

    @Override
    protected Converter<Model, ModelTO> getConverter() {
        return converter;
    }
}
