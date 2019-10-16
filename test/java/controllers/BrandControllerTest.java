package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static java.util.stream.Collectors.joining;
import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static play.test.Helpers.*;

public class BrandControllerTest extends WithApplication {

    private ObjectMapper jsonMapper = new ObjectMapper();

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testGetStructure() throws IOException {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/brand");

        Result result = route(app, request);
        System.out.println(result.body());

        assertJsonEquals(readResourceAsString("brands.json"), Helpers.contentAsString(result));
    }

    @Test
    public void testCreate() throws IOException {

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(POST)
                .bodyJson(jsonMapper.readTree(readResourceAsString("brand_create.json")))
                .uri("/brand");

        Result result = route(app, request);
        System.out.println(result.body());

        assertJsonEquals(readResourceAsString("brand_create_check.json"), Helpers.contentAsString(result));
    }

    @Test
    public void testUpdate() throws IOException {

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(PUT)
                .bodyJson(jsonMapper.readTree(readResourceAsString("brand_update.json")))
                .uri("/brand/1");

        Result result = route(app, request);
        System.out.println(result.body());

        assertJsonEquals(readResourceAsString("brand_update_check.json"), Helpers.contentAsString(result));
    }

    protected String readResourceAsString(String name) throws IOException {
        return readResourceAsString(name, StandardCharsets.UTF_8);
    }

    protected String readResourceAsString(String name, Charset charset) throws IOException {
        return Files.lines(getAsResource(name).toPath(), charset)
                .collect(joining(System.lineSeparator()));
    }

    protected File getAsResource(String name) throws IOException {
        return getAsResource(name, getClass());
    }

    public static File getAsResource(String name, Class<?> clazz) throws IOException {
        URL url = clazz.getClassLoader().getResource(name);
        if (url == null) {
            throw new IllegalStateException("Не найден ресурс: " + name);
        }
        return new File(url.getFile());
    }


}
