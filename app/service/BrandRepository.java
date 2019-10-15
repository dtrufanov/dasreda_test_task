package service;

import model.Brand;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class BrandRepository {
    private final Mapper mapper;
    private final ExecutionContext ec;

    @Inject
    public BrandRepository(Mapper mapper, ExecutionContext ec) {
        this.mapper = mapper;
        this.ec = ec;
    }

    CompletionStage<Stream<Brand>> list(){
        return supplyAsync(() -> mapper.getBrands().stream(), ec);
    }
}
