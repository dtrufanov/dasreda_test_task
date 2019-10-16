package service.repository;

import model.Position;
import service.execution.BrandExecutionContext;
import service.mapper.PositionMapper;

import javax.inject.Inject;

public class PositionRepository extends Repository<Position> {

    @Inject
    public PositionRepository(PositionMapper positionMapper, BrandExecutionContext ec) {
        this.mapper = positionMapper;
        this.ec = ec;
    }
}
