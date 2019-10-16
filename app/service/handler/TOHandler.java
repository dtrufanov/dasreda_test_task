package service.handler;

import model.Entity;
import model.Utils;
import model.to.EntityTO;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import service.repository.Repository;

import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public abstract class TOHandler<E extends Entity, T extends EntityTO> {

    protected Repository<E> repository;
    protected HttpExecutionContext ec;


    public CompletionStage<Stream<T>> getAll(Http.Request request) {
        return repository.list().thenApplyAsync(brandList -> brandList.stream().map(entity -> toEntityWithLink(request, entity)), ec.current());
    }

    protected abstract E toEntity(T to);
    protected abstract T toTO(E entity);

    private T toEntityWithLink(Http.Request request, E entity) {
        T entityTO = toTO(entity);
        entityTO.setLink(Utils.link(request, entity.getId(), entity.getClass().getSimpleName().toLowerCase()));
        return entityTO;
    }

    public CompletionStage<Optional<T>> get(Http.Request request, Long id) {
        return repository.get(id).thenApplyAsync(brandOptional -> brandOptional.map(entity -> toEntityWithLink(request, entity)), ec.current());
    }

    public CompletionStage<T> create(Http.Request request, T entityTO) {
        return repository.create(toEntity(entityTO)).thenApplyAsync(entity -> toEntityWithLink(request, entity));
    }

    public CompletionStage<Optional<T>> update(Http.Request request, T entityTO) {
        return repository.update(toEntity(entityTO)).thenApplyAsync(brandOptional -> brandOptional.map(entity -> toEntityWithLink(request, entity)), ec.current());
    }
    public CompletionStage<Boolean> delete(Long id) {
        return repository.delete(id);
    }
}
