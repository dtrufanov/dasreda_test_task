package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.to.EntityTO;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import service.handler.TOHandler;

import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

public abstract class CommonController<T extends EntityTO> extends Controller {

    protected HttpExecutionContext ec;
    protected TOHandler<?, T> handler;

    public CompletionStage<Result> getAll(Http.Request request) {
        return handler.getAll(request).thenApplyAsync(
                brandTOStream -> ok(Json.toJson(brandTOStream.collect(Collectors.toList()))),
                ec.current());
    }


    public CompletionStage<Result> get(Http.Request request, String id) {
        return handler.get(request, Long.parseLong(id)).thenApplyAsync(
                optionalBrandTO -> optionalBrandTO.map(
                        to -> ok(Json.toJson(to))).orElseGet(Results::notFound),
                ec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        final T to = Json.fromJson(json, getTOClass());
        return handler.create(request, to).thenApplyAsync(savedBrandTO -> created(Json.toJson(savedBrandTO)), ec.current());
    }

    public CompletionStage<Result> update(Http.Request request, String id) {
        JsonNode json = request.body().asJson();
        T to = Json.fromJson(json, getTOClass());
        to.setId(Long.parseLong(id));
        return handler.update(request, to).thenApplyAsync(
                optionalResource -> optionalResource.map(
                        r -> ok(Json.toJson(r))).orElseGet(Results::notFound),
                ec.current());
    }

    public CompletionStage<Result> delete(String id) {
        return handler.delete(Long.parseLong(id)).thenApplyAsync(b -> b ? ok() : notFound(), ec.current());
    }
    
    protected abstract Class<T> getTOClass();

}
