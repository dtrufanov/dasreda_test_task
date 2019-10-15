package controllers;

import model.to.BrandTO;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import service.BrandTOHandler;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private HttpExecutionContext ec;
    private BrandTOHandler handler;

    @Inject
    public HomeController(HttpExecutionContext ec, BrandTOHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    public CompletionStage<Result> brands(Http.Request request) {
        return handler.find(request).thenApplyAsync(posts -> {
            final List<BrandTO> postList = posts.collect(Collectors.toList());
            return ok(Json.toJson(postList));
        }, ec.current());
    }

}
