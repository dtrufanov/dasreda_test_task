package service.repository;

import model.Model;
import service.execution.ModelExecutionContext;
import service.mapper.ModelMapper;

import javax.inject.Inject;

public class ModelRepository extends Repository<Model> {
    @Inject
    public ModelRepository(ModelMapper modelMapper, ModelExecutionContext ec) {
        this.mapper = modelMapper;
        this.ec = ec;
    }
}
