package demo

import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient

def client = WebClient.create(vertx)
client.get(8083, 'localhost', '/presentation/10').send { asyncRequest ->
    if (asyncRequest.succeeded()) {
        def result = asyncRequest.result()
        println result.body()
    } else {
        println "Failed with reason: ${asyncRequest.cause().getMessage()}"
    }
}