package demo

import io.vertx.core.http.HttpServer
import io.vertx.core.json.Json
import io.vertx.ext.web.Router

Router router = Router.router(vertx)
router.get("/presentation/:presentationId").handler { context ->
    context.response()
            .putHeader("content-type", "application/json")
            .end(Json.encodePrettily(
            getPresentation(
                    context.request().getParam('presentationId')
            )))
}
HttpServer httpServer = vertx.createHttpServer()
httpServer.requestHandler(router.&accept).listen(8082)

static Presentation getPresentation(String id) {
    new Presentation(id: id as Long, title: 'Vert.x demo', speakerId: 1)
}

class Presentation {
    Long id
    String title
    Long speakerId
}
