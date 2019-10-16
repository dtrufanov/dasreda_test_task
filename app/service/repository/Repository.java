package service.repository;

import model.Entity;
import scala.concurrent.ExecutionContextExecutor;
import service.mapper.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public abstract class Repository<E extends Entity> {
    protected Mapper<E> mapper;
    protected ExecutionContextExecutor ec;

    public CompletionStage<List<E>> list(){
        return supplyAsync(mapper::getAll, ec);
    }

    public CompletionStage<Optional<E>> get(Long id){
        return supplyAsync(() -> Optional.ofNullable(mapper.get(id)), ec);
    }


    public CompletionStage<E> create(E entity) {
        return supplyAsync(() -> {
            mapper.create(entity);
            return entity.getId();
        }, ec).thenApplyAsync(id -> mapper.get(entity.getId()), ec);
    }


    public CompletionStage<Optional<E>> update(E entity) {
        return supplyAsync(() -> {
            mapper.update(entity);
            return entity.getId();
        }, ec).thenApplyAsync(id -> Optional.ofNullable(mapper.get(entity.getId())), ec);

    }

    public CompletionStage<Boolean> delete(Long id) {
        return supplyAsync(() -> mapper.delete(id) > 0, ec);
    }
}
