package model;

import com.palominolabs.http.url.UrlBuilder;
import play.mvc.Http;

import java.nio.charset.CharacterCodingException;

public final class Utils {
    private Utils(){}

    public static String link(Http.Request request, Long id, String... resources) {
        final String[] hostPort = request.host().split(":");
        String host = hostPort[0];
        int port = (hostPort.length == 2) ? Integer.parseInt(hostPort[1]) : -1;
        final String scheme = request.secure() ? "https" : "http";
        try {
            return UrlBuilder.forHost(scheme, host, port)
                    .pathSegments(resources)
                    .pathSegment(id.toString())
                    .toUrlString();
        } catch (CharacterCodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
