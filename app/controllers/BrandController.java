package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.to.BrandTO;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import service.BrandTOHandler;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class BrandController extends Controller {

    private HttpExecutionContext ec;
    private BrandTOHandler handler;

    @Inject
    public BrandController(HttpExecutionContext ec, BrandTOHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

    public CompletionStage<Result> getAll(Http.Request request) {
        return handler.getAll(request).thenApplyAsync(
                brandTOStream -> ok(Json.toJson(brandTOStream.collect(Collectors.toList()))),
                ec.current());
    }


    public CompletionStage<Result> get(Http.Request request, String id) {
        return handler.get(request, Long.parseLong(id)).thenApplyAsync(
                optionalBrandTO -> optionalBrandTO.map(
                        brandTO -> ok(Json.toJson(brandTO))).orElseGet(Results::notFound),
                ec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        final BrandTO brandTO = Json.fromJson(json, BrandTO.class);
        return handler.create(request, brandTO).thenApplyAsync(savedBrandTO -> created(Json.toJson(savedBrandTO)), ec.current());
    }

    public CompletionStage<Result> update(Http.Request request, String id) {
        JsonNode json = request.body().asJson();
        BrandTO brandTO = Json.fromJson(json, BrandTO.class);
        brandTO.setId(Long.parseLong(id));
        return handler.update(request, brandTO).thenApplyAsync(
                optionalResource -> optionalResource.map(
                        r -> ok(Json.toJson(r))).orElseGet(Results::notFound),
                ec.current());
    }

    public CompletionStage<Result> delete(String id) {
        return handler.delete(Long.parseLong(id)).thenApplyAsync(b -> b ? ok() : notFound(), ec.current());
    }

}
