package service.handler.converter;

import model.Entity;
import model.to.EntityTO;

public abstract class Converter<E extends Entity, T extends EntityTO> {
    public abstract E toEntity(T to);
    public abstract T toTO(E entity);
}
