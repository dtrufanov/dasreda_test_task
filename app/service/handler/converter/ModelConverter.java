package service.handler.converter;

import model.Model;
import model.to.ModelTO;

public class ModelConverter extends Converter<Model, ModelTO> {
    @Override
    public Model toEntity(ModelTO to) {
        Model model = new Model();
        model.setId(to.getId());
        model.setName(to.getName());
        model.setProductionStart(to.getProductionStart());
        model.setProductionStop(to.getProductionStop());
        return model;
    }

    @Override
    public ModelTO toTO(Model model) {
        ModelTO to = new ModelTO();
        to.setId(model.getId());
        to.setName(model.getName());
        to.setProductionStart(model.getProductionStart());
        to.setProductionStop(model.getProductionStop());
        return to;
    }
}
