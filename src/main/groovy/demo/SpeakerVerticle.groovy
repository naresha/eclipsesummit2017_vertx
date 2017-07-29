package demo

import io.vertx.core.http.HttpServer
import io.vertx.core.json.Json
import io.vertx.ext.web.Router


Router router = Router.router(vertx)
router.get("/speaker/:speakerId").handler { context ->
    context.response()
            .putHeader("content-type", "application/json")
            .end(Json.encodePrettily(
            getSpeaker(
                    context.request().getParam('speakerId')
            )))
}
HttpServer httpServer = vertx.createHttpServer()
httpServer.requestHandler(router.&accept).listen(8081)


static Speaker getSpeaker(String id) {
    Long speakerId = Long.parseLong(id);
    new Speaker(id: speakerId, name: 'Tim')
}

class Speaker {
    Long id
    String name
}
