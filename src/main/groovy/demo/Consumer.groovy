package demo

def eventBus = vertx.eventBus()
eventBus.consumer("vertx.message") { message ->
    println "Received: " + message.body()
}
