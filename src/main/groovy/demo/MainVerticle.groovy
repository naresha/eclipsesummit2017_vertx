package demo

import io.vertx.core.Vertx

vertx.deployVerticle("./SpeakerVerticle.groovy")
vertx.deployVerticle("./PresentationVerticle.groovy")


