package service.handler;

import model.Entity;
import model.Utils;
import model.to.EntityTO;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import service.handler.converter.Converter;
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

    public CompletionStage<Optional<T>> get(Http.Request request, Long id) {
        return repository.get(id).thenApplyAsync(brandOptional -> brandOptional.map(entity -> toEntityWithLink(request, entity)), ec.current());
    }

    public CompletionStage<T> create(Http.Request request, T entityTO) {
        return repository.create(getConverter().toEntity(entityTO)).thenApplyAsync(entity -> toEntityWithLink(request, entity));
    }

    public CompletionStage<Optional<T>> update(Http.Request request, T entityTO) {
        return repository.update(getConverter().toEntity(entityTO)).thenApplyAsync(brandOptional -> brandOptional.map(entity -> toEntityWithLink(request, entity)), ec.current());
    }
    public CompletionStage<Boolean> delete(Long id) {
        return repository.delete(id);
    }


    protected abstract Converter<E, T> getConverter();

    private T toEntityWithLink(Http.Request request, E entity) {
        T entityTO = getConverter().toTO(entity);
        setLinks(request, entityTO, entity);
        return entityTO;
    }

    protected void setLinks(Http.Request request, T to, E entity) {
        setLink(request, to, entity);
    }

    protected void setLink(Http.Request request, EntityTO to, Entity entity) {
        to.setLink(Utils.link(request, entity.getId(), entity.getClass().getSimpleName().toLowerCase()));
    }

}
