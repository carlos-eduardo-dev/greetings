package com.greetings.controllers

import com.greetings.controllers.routes.GreetingsControllerRoutes
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller('/greetings')
class GreetingsController implements GreetingsControllerRoutes {

    @Value('${greetings.message}')
    private String greetings

    @Value('${greetings.instance}')
    private String instance

    @Get('/')
    HttpResponse<HttpStatus> index() {
        return HttpResponse.status(HttpStatus.OK)
    }

    @Override
    HttpResponse<String> greetings(final String name) {
        final String message = "${greetings}, ${name}! This is instance ${instance}."
        return HttpResponse.ok(message)
    }
}
