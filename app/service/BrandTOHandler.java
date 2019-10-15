package service;

import model.Brand;
import model.to.BrandTO;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import javax.inject.Inject;
import java.util.Optional;
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

    public CompletionStage<Stream<BrandTO>> getAll(Http.Request request) {
        return brandRepository.list().thenApplyAsync(brandList -> brandList.stream().map(BrandTO::new), ec.current());
    }

    public CompletionStage<Optional<BrandTO>> get(Http.Request request, Long id) {
        return brandRepository.get(id).thenApplyAsync(brand -> brand.map(BrandTO::new), ec.current());
    }

    public CompletionStage<Brand> create(Http.Request request, BrandTO brandTO) {
        return brandRepository.create(brandTO.toBrand());
    }

    public CompletionStage<Optional<BrandTO>> update(Http.Request request, BrandTO brandTO) {
        return brandRepository.update(brandTO.toBrand()).thenApplyAsync(brand -> brand.map(BrandTO::new), ec.current());
    }
    public CompletionStage<Boolean> delete(Long id) {
        return brandRepository.delete(id);
    }
}
