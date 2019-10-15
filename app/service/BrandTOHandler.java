package service;

import model.to.BrandTO;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public class BrandTOHandler {

    private final BrandRepository brandRepository;
    private final HttpExecutionContext ec;

    @Inject
    public BrandTOHandler(BrandRepository brandRepository, HttpExecutionContext ec) {
        this.brandRepository = brandRepository;
        this.ec = ec;
    }

    public CompletionStage<Stream<BrandTO>> find(Http.Request request) {
        return brandRepository.list().thenApplyAsync(postDataStream -> postDataStream.map(BrandTO::new), ec.current());
    }
}
