package service;

import model.Brand;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class BrandRepository {
    private final BrandMapper brandMapper;
    private final BrandExecutionContext ec;


    @Inject
    public BrandRepository(BrandMapper brandMapper, BrandExecutionContext ec) {
        this.brandMapper = brandMapper;
        this.ec = ec;
    }

    CompletionStage<List<Brand>> list(){
        return supplyAsync(brandMapper::getBrands, ec);
    }

    CompletionStage<Optional<Brand>> get(Long id){
        return supplyAsync(() -> Optional.ofNullable(brandMapper.getBrand(id)), ec);
    }


    public CompletionStage<Brand> create(Brand brand) {
        return supplyAsync(() -> {
            brandMapper.create(brand);
            return brandMapper.getBrand(brand.getId());
        }, ec);
    }


    public CompletionStage<Optional<Brand>> update(Brand brand) {
        return supplyAsync(() -> {
            brandMapper.update(brand);
            return Optional.ofNullable(brandMapper.getBrand(brand.getId()));
        }, ec);
    }

    public CompletionStage<Boolean> delete(Long id) {
        return supplyAsync(() -> brandMapper.delete(id) > 0, ec);
    }
}
