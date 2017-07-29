var Vertx = require("vertx-js/vertx");

var eventBus = vertx.eventBus();
vertx.setPeriodic(1000, function (id) {
    console.log("Publishing JS Message");
    eventBus.publish("vertx.message", "Hello from JS " + new Date());
});