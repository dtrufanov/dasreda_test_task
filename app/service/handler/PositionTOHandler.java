package service.handler;

import model.Position;
import model.to.PositionTO;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import service.handler.converter.Converter;
import service.handler.converter.PositionConverter;
import service.repository.PositionRepository;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public class PositionTOHandler extends TOHandler<Position, PositionTO> {
    private final PositionConverter converter = new PositionConverter();

    @Inject
    public PositionTOHandler(PositionRepository positionRepository, HttpExecutionContext ec) {
        this.repository = positionRepository;
        this.ec = ec;
    }

    @Override
    public CompletionStage<Stream<PositionTO>> getAll(Http.Request request) {
        return ((PositionRepository) repository).search(request.getQueryString("search")).thenApplyAsync(
                positionList -> positionList.stream().map(position -> toEntityWithLink(request, position)), ec.current());
    }

    @Override
    protected void setLinks(Http.Request request, PositionTO to, Position entity) {
        super.setLinks(request, to, entity);
        setLink(request, to.getModel(), entity.getModel());
        setLink(request, to.getBrand(), entity.getBrand());
    }

    @Override
    protected Converter<Position, PositionTO> getConverter() {
        return converter;
    }
}
