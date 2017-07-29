package demo

import java.time.LocalDateTime

def eventBus = vertx.eventBus()
vertx.setPeriodic(1000, { id ->
    println "Publishing Groovy message"
    eventBus.publish("vertx.message", "Hello from Groovy " + LocalDateTime.now())
})

