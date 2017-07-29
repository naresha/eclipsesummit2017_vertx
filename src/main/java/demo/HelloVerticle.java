package demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

public class HelloVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        System.out.println("Hello from Verticle");
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(context ->
                context.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Verticle")
        );
        httpServer.listen(8080);
    }
}
