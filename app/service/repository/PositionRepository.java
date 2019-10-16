package service.repository;

import model.Position;
import service.execution.PositionExecutionContext;
import service.mapper.PositionMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class PositionRepository extends Repository<Position> {

    @Inject
    public PositionRepository(PositionMapper positionMapper, PositionExecutionContext ec) {
        this.mapper = positionMapper;
        this.ec = ec;
    }

    public CompletionStage<List<Position>> search(String search){
        return supplyAsync(() -> ((PositionMapper) mapper).search(search), ec);
    }
}
